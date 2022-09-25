package com.example.mobileuptestapp.main.presentation

import android.widget.ImageView
import android.widget.TextView
import com.example.mobileuptestapp.core.ToMapper
import com.example.mobileuptestapp.customviews.PositiveAndNegativeTextView
import com.squareup.picasso.Picasso

data class CryptoUi(
    private val id: String,
    private val symbol: String,
    private val name: String,
    private val image: String,
    private val current_price: Double,
    private val ath_change_percentage: Double,
    private val currency: String
): ToMapper<CryptoTransfer> {

    override fun map() = CryptoTransfer(id, name)

    fun sameId(cryptoUi: CryptoUi) = this.id == cryptoUi.id

    fun sameCrypto(cryptoUi: CryptoUi) = this == cryptoUi

    fun setInfo(name: TextView, image: ImageView, currentPrice: TextView, change: PositiveAndNegativeTextView,
        shortName: TextView) {
        name.text = this.name
        currentPrice.text = "${getCurrency()} ${this.current_price}"
        change.setText(ath_change_percentage)
        shortName.text = symbol.uppercase()
        //TODO сделать отдельный класс для картинок
        Picasso.get().load(this.image).into(image)
    }

    //TODO убрать геттеры
    fun getId() = this.id

    fun getName() = this.name

    private fun getCurrency(): String {
        return when(currency) {
            "usd" -> "$"
            "eur" -> "€"
            else -> "undefined"
        }
    }
}
