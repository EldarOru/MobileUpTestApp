package com.example.mobileuptestapp.core

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileuptestapp.main.presentation.CryptoUi
import com.example.mobileuptestapp.main.presentation.MainAdapter

interface StateHandler<T> {

    fun setState(state: State<T>)
}

class BaseStateHandler(
    private val progressBar: ProgressBar,
    private val errorButton: Button,
    private val errorText: TextView,
    private val recyclerView: RecyclerView,
    private val adapter: ListAdapter<CryptoUi, MainAdapter.CryptoVH>
) : StateHandler<List<CryptoUi>>{

    private fun showLoading() {
        errorButton.visibility = View.GONE
        errorText.visibility = View.GONE
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    private fun showError(error: String) {
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.GONE
        errorButton.visibility = View.VISIBLE
        errorText.apply {
            visibility = View.VISIBLE
            text = error
        }
    }

    private fun showData(data: List<CryptoUi>) {
        progressBar.visibility = View.GONE
        errorButton.visibility = View.GONE
        errorText.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
        adapter.submitList(data)
    }

    private fun showDefault() {
        errorButton.visibility = View.GONE
        errorText.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun setState(state: State<List<CryptoUi>>) {
        when (state) {
            is State.isLoading -> showLoading()
            is State.Error -> showError(state.getErrorMessage())
            is State.Loaded -> showData(state.getData())
            is State.Default -> showDefault()
        }
    }
}