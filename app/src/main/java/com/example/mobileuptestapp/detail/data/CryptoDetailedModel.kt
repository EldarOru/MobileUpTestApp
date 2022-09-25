package com.example.mobileuptestapp.detail.data

import com.example.mobileuptestapp.core.ToMapper
import com.example.mobileuptestapp.detail.presenation.CryptoDetailedUi

data class CryptoDetailedModel(
    private val id: String,
    private val symbol: String,
    private val name: String,
    private val description: Description,
    private val categories: List<String>,
    private val image: Image
) : ToMapper<CryptoDetailedUi> {

    override fun map(): CryptoDetailedUi {
        return CryptoDetailedUi(description.en, categories, image.large)
    }

    inner class Description(
        val en: String
    )

    inner class Image(
        val large: String
    )
}

