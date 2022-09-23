package com.example.mobileuptestapp.core

interface MainRepository<T> {

    suspend fun getItemList(type: String): List<T>
}