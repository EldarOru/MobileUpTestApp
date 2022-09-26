package com.example.mobileuptestapp.main.presentation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CryptoTransfer(
    private val id: String,
    private val name: String,
) : Parcelable {

    //исправить геттеры
    fun getId() = id

    fun getName() = name
}