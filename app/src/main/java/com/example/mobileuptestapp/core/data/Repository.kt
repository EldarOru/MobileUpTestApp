package com.example.mobileuptestapp.core.data

interface Repository<T> {

    suspend fun getData(type: String): T
}