package com.example.mobileuptestapp.core

import com.example.mobileuptestapp.main.presentation.CryptoUi

sealed class CryptoItem: ToMapper<CryptoUi>  {
    class Success(
        private val id: String,
        private val symbol: String,
        private val name: String,
        private val image: String,
        private val current_price: Double,
        private val ath_change_percentage: Double
    ) : CryptoItem() {

        override fun map(): CryptoUi = CryptoUi(id, symbol, name, image, current_price, ath_change_percentage)

    }

    class Fail(private val failure: Failure) : CryptoItem() {

        override fun map(): CryptoUi {
            TODO()
        }
    }
}