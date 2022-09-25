package com.example.mobileuptestapp.core.data

interface RemoteDataSource<T> {

    suspend fun getData(type: String): List<T>
}