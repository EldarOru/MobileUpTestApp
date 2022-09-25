package com.example.mobileuptestapp.detail.presenation

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.mobileuptestapp.core.presentation.State
import com.example.mobileuptestapp.core.presentation.StateHandler

class DetailedStateHandler(
    progressBar: ProgressBar,
    errorButton: Button,
    errorText: TextView,
    private val layout: InfoLayout,
) : StateHandler<CryptoDetailedUi>(
    progressBar, errorButton, errorText
) {

    override fun hideInfoLayout() {
        layout.layout.visibility = View.GONE
    }

    override fun showLayoutInfo(data: CryptoDetailedUi) {
        layout.layout.visibility = View.VISIBLE
        data.setInfo(layout)
    }
}