package com.example.mobileuptestapp.detail.presenation

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.mobileuptestapp.core.presentation.State
import com.example.mobileuptestapp.core.presentation.StateHandler

class DetailedStateHandler(
    private val progressBar: ProgressBar,
    private val errorButton: Button,
    private val errorText: TextView,
    private val layout: InfoLayout,
) : StateHandler<CryptoDetailedUi> {

    private fun showLoading() {
        errorButton.visibility = View.GONE
        errorText.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        layout.layout.visibility = View.GONE
    }

    private fun showError(error: String) {
        progressBar.visibility = View.GONE
        layout.layout.visibility = View.GONE
        errorButton.visibility = View.VISIBLE
        errorText.visibility = View.VISIBLE
        errorText.text = error
    }

    private fun showData(data: CryptoDetailedUi) {
        progressBar.visibility = View.GONE
        errorButton.visibility = View.GONE
        errorText.visibility = View.GONE
        layout.layout.visibility = View.VISIBLE
        data.setInfo(layout)
    }

    private fun showDefault() {
        errorButton.visibility = View.GONE
        errorText.visibility = View.GONE
        progressBar.visibility = View.GONE
        layout.layout.visibility = View.GONE
    }


    override fun setState(state: State<CryptoDetailedUi>) {
        when (state) {
            is State.isLoading -> showLoading()
            is State.Error -> showError(state.getErrorMessage())
            is State.Loaded -> showData(state.getData())
            is State.Default -> showDefault()
        }
    }
}