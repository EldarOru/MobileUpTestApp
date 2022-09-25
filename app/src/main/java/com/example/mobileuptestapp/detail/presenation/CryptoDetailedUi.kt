package com.example.mobileuptestapp.detail.presenation

import com.squareup.picasso.Picasso

class CryptoDetailedUi(
    private val description: String,
    private val categories: List<String>,
    private val image: String
) {

    fun setInfo(infoLayout: InfoLayout) {
        Picasso.get().load(image).into(infoLayout.imageView)
        infoLayout.description.text = cleanDescriptionFromHref()
        infoLayout.categories.text = categoriesToString()
    }

    private fun categoriesToString(): String {
        var res = ""
        categories.map {
            res += it + "\n"
        }
        return res
    }

    private fun cleanDescriptionFromHref(): String {
        val secRegex = Regex("<[^>]*>")
        return secRegex.replace(this.description, "")
    }
}