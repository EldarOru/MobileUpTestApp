package com.example.mobileuptestapp.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseMainRepository(
    private val remoteDataSource: RemoteDataSource<CryptoItem>,
) : MainRepository<CryptoItem> {

    override suspend fun getItemList(type: String): List<CryptoItem> = withContext(Dispatchers.IO) {
        remoteDataSource.getData(type)
    }
}