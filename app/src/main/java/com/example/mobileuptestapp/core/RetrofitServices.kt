package com.example.mobileuptestapp.core

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServices {

    @GET("coins/markets")
    suspend fun getCrypto(
        @Query("vs_currency") currency: String,
        @Query("per_page") perPage: Int = DEFAULT_PAGE_SIZE,
    ) : Call<List<CryptoItem>>

    @GET("coins/{id}")
    suspend fun getDetailedCrypto(
        @Path("id") id: String
    ) : Call<CryptoDetailed>

    companion object {
        private const val DEFAULT_PAGE_SIZE = 25
    }
}

