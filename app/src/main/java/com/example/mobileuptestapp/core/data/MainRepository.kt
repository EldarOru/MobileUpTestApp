package com.example.mobileuptestapp.core.data

interface MainRepository<T> {

    suspend fun getItemList(type: String): List<T>
}