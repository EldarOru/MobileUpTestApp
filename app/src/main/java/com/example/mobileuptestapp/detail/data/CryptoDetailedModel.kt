package com.example.mobileuptestapp.detail.data

data class CryptoDetailed(
    private val id: String,
    private val symbol: String,
    private val name: String,
    private val description: Description,
    private val categories: List<String>,
    private val image: Image
)

data class Description(
    private val en: String
)

data class Image(
    private val thumb: String,
    private val small: String,
    private val large: String
)