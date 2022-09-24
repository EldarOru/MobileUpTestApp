package com.example.mobileuptestapp.core

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseMainRepository(
    private val remoteDataSource: RemoteDataSource<CryptoModel>,
) : MainRepository<CryptoModel> {

    override suspend fun getItemList(type: String): List<CryptoModel> = withContext(Dispatchers.IO) {
        remoteDataSource.getData(type)
    }
}