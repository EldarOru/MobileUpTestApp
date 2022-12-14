package com.example.mobileuptestapp.detail.presenation

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.mobileuptestapp.core.presentation.StateHandler

class DetailedStateHandler(
    progressBar: ProgressBar,
    errorButton: Button,
    errorText: TextView,
    errorImageView: ImageView,
    private val layout: InfoLayout,
) : StateHandler<CryptoDetailedUi>(
    progressBar, errorButton, errorText, errorImageView
) {

    override fun hideInfoLayout() {
        layout.layout.visibility = View.GONE
    }

    override fun showLayoutInfo(data: CryptoDetailedUi) {
        layout.layout.visibility = View.VISIBLE
        data.setInfo(layout)
    }
}