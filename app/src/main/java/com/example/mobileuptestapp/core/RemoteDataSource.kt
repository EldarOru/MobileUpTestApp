package com.example.mobileuptestapp.core

interface RemoteDataSource<T> {

    suspend fun getData(type: String): List<T>

}