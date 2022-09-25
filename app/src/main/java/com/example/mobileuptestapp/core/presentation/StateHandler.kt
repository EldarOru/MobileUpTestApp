package com.example.mobileuptestapp.core.presentation

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

abstract class StateHandler<T>(
    private val progressBar: ProgressBar,
    private val errorButton: Button,
    private val errorText: TextView,
) {

    private fun showLoading() {
        errorButton.visibility = View.GONE
        errorText.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        hideInfoLayout()
    }

    private fun showError(error: String) {
        progressBar.visibility = View.GONE
        hideInfoLayout()
        errorButton.visibility = View.VISIBLE
        errorText.visibility = View.VISIBLE
        errorText.text = error
    }

    private fun showData(data: T) {
        progressBar.visibility = View.GONE
        errorButton.visibility = View.GONE
        errorText.visibility = View.GONE
        showLayoutInfo(data)
    }

    private fun showDefault() {
        errorButton.visibility = View.GONE
        errorText.visibility = View.GONE
        hideInfoLayout()
        progressBar.visibility = View.GONE
    }

    protected abstract fun hideInfoLayout()

    protected abstract fun showLayoutInfo(data: T)

    fun setState(state: State<T>) {
        when (state) {
            is State.IsLoading -> showLoading()
            is State.Error -> showError(state.getErrorMessage())
            is State.Loaded -> showData(state.getData())
            is State.Default -> showDefault()
        }
    }
}
