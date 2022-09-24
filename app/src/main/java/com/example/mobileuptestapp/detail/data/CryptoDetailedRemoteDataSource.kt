package com.example.mobileuptestapp.detail.data

import com.example.mobileuptestapp.core.data.RetrofitServices
import com.example.mobileuptestapp.core.data.SingleRemoteDataSource
import com.example.mobileuptestapp.core.domain.NoConnectionException
import com.example.mobileuptestapp.core.domain.ServiceUnavailableException
import java.net.UnknownHostException

class CryptoDetailedRemoteDataSource(private val retrofitServices: RetrofitServices) :
    SingleRemoteDataSource<CryptoDetailedModel> {

    override suspend fun getData(id: String): CryptoDetailedModel {
        try {
            return retrofitServices.getDetailedCrypto(id)
        } catch (e: Exception) {
            if (e is UnknownHostException) throw NoConnectionException()
            else throw ServiceUnavailableException()
        }
    }
}