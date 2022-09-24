package com.example.mobileuptestapp.detail.data

import com.example.mobileuptestapp.core.data.SingleRemoteDataSource
import com.example.mobileuptestapp.core.data.SingleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CryptoDetailedRepository(
    private val remoteDataSource: SingleRemoteDataSource<CryptoDetailedModel>,
) : SingleRepository<CryptoDetailedModel> {

    override suspend fun getItem(id: String): CryptoDetailedModel =
        withContext(Dispatchers.IO) {
            remoteDataSource.getData(id)
        }
}