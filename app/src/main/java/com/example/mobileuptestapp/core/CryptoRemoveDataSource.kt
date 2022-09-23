package com.example.mobileuptestapp.core

import java.lang.Exception
import java.net.UnknownHostException

class CryptoRemoveDataSource(private val retrofitServices: RetrofitServices): RemoteDataSource<CryptoItem> {

    override suspend fun getData(type: String): List<CryptoItem> {
        try {
            return retrofitServices.getCrypto(type).execute().body()!!
        } catch (e: Exception) {
            if (e is UnknownHostException) throw NoConnectionException()
            else throw ServiceUnavailableException()
        }
    }
}