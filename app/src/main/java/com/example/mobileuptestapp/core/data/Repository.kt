package com.example.mobileuptestapp.core.data

interface Repository<T> {

    suspend fun getItemList(type: String): List<T>
}