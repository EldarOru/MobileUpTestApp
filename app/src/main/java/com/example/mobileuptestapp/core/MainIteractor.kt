package com.example.mobileuptestapp.core

interface MainIteractor<T> {

    suspend fun getItemList(type: String): State<T>
}