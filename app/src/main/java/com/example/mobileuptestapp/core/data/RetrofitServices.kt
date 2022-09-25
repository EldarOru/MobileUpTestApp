package com.example.mobileuptestapp.core.data

import com.example.mobileuptestapp.detail.data.CryptoDetailedModel
import com.example.mobileuptestapp.main.data.CryptoModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServices {

    @GET("coins/markets")
    suspend fun getCrypto(
        @Query("vs_currency") currency: String,
        @Query("per_page") perPage: Int = DEFAULT_PAGE_SIZE,
    ): List<CryptoModel>

    @GET("coins/{id}")
    suspend fun getDetailedCrypto(
        @Path("id") id: String
    ): CryptoDetailedModel

    companion object {
        private const val DEFAULT_PAGE_SIZE = 25
    }
}

