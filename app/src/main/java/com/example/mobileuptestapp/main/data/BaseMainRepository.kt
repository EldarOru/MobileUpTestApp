package com.example.mobileuptestapp.main.data

import com.example.mobileuptestapp.core.data.MainRepository
import com.example.mobileuptestapp.core.data.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseMainRepository(
    private val remoteDataSource: RemoteDataSource<CryptoModel>,
) : MainRepository<CryptoModel> {

    override suspend fun getItemList(type: String): List<CryptoModel> =
        withContext(Dispatchers.IO) {
            remoteDataSource.getData(type)
        }
}