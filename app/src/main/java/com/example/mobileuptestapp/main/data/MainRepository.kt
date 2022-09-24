package com.example.mobileuptestapp.main.data

import com.example.mobileuptestapp.core.data.Repository
import com.example.mobileuptestapp.core.data.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(
    private val remoteDataSource: RemoteDataSource<CryptoModel>,
) : Repository<CryptoModel> {

    override suspend fun getItemList(type: String): List<CryptoModel> =
        withContext(Dispatchers.IO) {
            remoteDataSource.getData(type)
        }
}