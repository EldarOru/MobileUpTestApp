package com.example.mobileuptestapp.main.data

import com.example.mobileuptestapp.core.ToMapper
import com.example.mobileuptestapp.core.ToMapperWith
import com.example.mobileuptestapp.main.presentation.CryptoUi

data class CryptoModel(
    private val id: String,
    private val symbol: String,
    private val name: String,
    private val image: String,
    private val current_price: Double,
    private val ath_change_percentage: Double
) : ToMapperWith<CryptoUi, String> {

    override fun map(data: String): CryptoUi = CryptoUi(
        id, symbol, name, image, current_price, ath_change_percentage, data
    )
}