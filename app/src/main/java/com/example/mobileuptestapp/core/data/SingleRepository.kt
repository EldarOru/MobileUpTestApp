package com.example.mobileuptestapp.core.data

interface SingleRepository<T> {

    suspend fun getItem(id: String): T
}