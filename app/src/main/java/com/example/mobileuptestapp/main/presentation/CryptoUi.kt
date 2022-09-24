package com.example.mobileuptestapp.main.presentation

import android.widget.TextView

data class CryptoUi(
    private val id: String,
    private val symbol: String,
    private val name: String,
    private val image: String,
    private val current_price: Double,
    private val ath_change_percentage: Double
) {

    fun sameId(cryptoUi: CryptoUi) = this.id == cryptoUi.id

    fun sameCrypto(cryptoUi: CryptoUi) = this == cryptoUi

    fun setInfo(name: TextView) {
        name.text = this.name
    }
}
