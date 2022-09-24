package com.example.mobileuptestapp.core

import java.lang.Exception
import java.net.UnknownHostException

class CryptoRemoveDataSource(private val retrofitServices: RetrofitServices): RemoteDataSource<CryptoModel> {

    override suspend fun getData(type: String): List<CryptoModel> {
        try {
            return retrofitServices.getCrypto(type)
        } catch (e: Exception) {
            if (e is UnknownHostException) throw NoConnectionException()
            else throw ServiceUnavailableException()
        }
    }
}