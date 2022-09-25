package com.example.mobileuptestapp.main.data

import com.example.mobileuptestapp.core.data.RemoteDataSource
import com.example.mobileuptestapp.core.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(
    private val remoteDataSource: RemoteDataSource<List<CryptoModel>>,
) : Repository<List<CryptoModel>> {

    override suspend fun getData(type: String): List<CryptoModel> =
        withContext(Dispatchers.IO) {
            remoteDataSource.getData(type)
        }
}