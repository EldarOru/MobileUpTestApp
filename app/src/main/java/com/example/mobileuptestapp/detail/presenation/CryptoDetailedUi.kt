package com.example.mobileuptestapp.detail.presenation

import com.squareup.picasso.Picasso

class CryptoDetailedUi(
    private val id: String,
    private val symbol: String,
    private val name: String,
    private val description: String,
    private val categories: List<String>,
    private val image: String
) {

    fun setInfo(infoLayout: InfoLayout) {
        Picasso.get().load(image).into(infoLayout.imageView)
        infoLayout.description.text = cleanDescription()
        infoLayout.categories.text = categoriesToString()
    }

    private fun categoriesToString(): String {
        var res = ""
        categories.map {
            res+=it + "\n"
        }
        return res
    }

    private fun cleanDescription(): String {
        val regex = Regex("<a\\b[^>]+>([^<]*(?:(?!</a)<[^<]*)*)</a>")
        //TODO исправить
        val secRegex = Regex("<a.*?</a>")
        return secRegex.replace(this.description, "")
    }
}