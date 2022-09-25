package com.example.mobileuptestapp.detail.data

import com.example.mobileuptestapp.core.data.RemoteDataSource
import com.example.mobileuptestapp.core.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CryptoDetailedRepository(
    private val remoteDataSource: RemoteDataSource<CryptoDetailedModel>,
) : Repository<CryptoDetailedModel> {

    override suspend fun getData(type: String): CryptoDetailedModel =
        withContext(Dispatchers.IO) {
            remoteDataSource.getData(type)
        }
}