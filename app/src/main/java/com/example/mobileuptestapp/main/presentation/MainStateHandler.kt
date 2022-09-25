package com.example.mobileuptestapp.main.presentation

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileuptestapp.core.presentation.State
import com.example.mobileuptestapp.core.presentation.StateHandler

class MainStateHandler(
    progressBar: ProgressBar,
    errorButton: Button,
    errorText: TextView,
    private val recyclerView: RecyclerView,
    private val adapter: ListAdapter<CryptoUi, MainAdapter.CryptoVH>
) : StateHandler<List<CryptoUi>>(
    progressBar, errorButton, errorText
) {

    override fun hideInfoLayout() {
        recyclerView.visibility = View.GONE
    }

    override fun showLayoutInfo(data: List<CryptoUi>) {
        adapter.submitList(data)
        recyclerView.visibility = View.VISIBLE
    }
}