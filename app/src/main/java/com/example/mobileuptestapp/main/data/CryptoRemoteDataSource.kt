package com.example.mobileuptestapp.main.data

import com.example.mobileuptestapp.core.data.RemoteDataSource
import com.example.mobileuptestapp.core.data.RetrofitServices
import com.example.mobileuptestapp.core.domain.NoConnectionException
import com.example.mobileuptestapp.core.domain.ServiceUnavailableException
import java.net.UnknownHostException

class CryptoRemoteDataSource(private val retrofitServices: RetrofitServices) :
    RemoteDataSource<List<CryptoModel>> {

    override suspend fun getData(type: String): List<CryptoModel> {
        try {
            return retrofitServices.getCrypto(type)
        } catch (e: Exception) {
            if (e is UnknownHostException) throw NoConnectionException()
            else throw ServiceUnavailableException()
        }
    }
}