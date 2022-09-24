package com.example.mobileuptestapp.core.data

interface SingleRemoteDataSource<T> {

    suspend fun getData(id: String): T
}