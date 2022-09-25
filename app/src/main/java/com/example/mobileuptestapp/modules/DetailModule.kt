package com.example.mobileuptestapp.modules

import android.content.Context
import com.example.mobileuptestapp.core.BaseResourceManager
import com.example.mobileuptestapp.core.data.RetrofitClient
import com.example.mobileuptestapp.core.domain.FailureFactory
import com.example.mobileuptestapp.core.presentation.BaseViewModel
import com.example.mobileuptestapp.core.presentation.Communication
import com.example.mobileuptestapp.detail.data.CryptoDetailedRemoteDataSource
import com.example.mobileuptestapp.detail.data.CryptoDetailedRepository
import com.example.mobileuptestapp.detail.domain.CryptoDetailedIteractor
import com.example.mobileuptestapp.detail.presenation.CryptoDetailedUi
import com.example.mobileuptestapp.detail.presenation.CryptoDetailedViewModel

class DetailModule(private val applicationContext: Context) : CreateViewModel<CryptoDetailedUi> {

    override fun createViewModel(): BaseViewModel<CryptoDetailedUi> {
        val service = RetrofitClient().retrofitServices
        val cryptoDetailedDataSource = CryptoDetailedRemoteDataSource(service)
        val detailedRepository = CryptoDetailedRepository(cryptoDetailedDataSource)
        val failureFactory = FailureFactory(BaseResourceManager(applicationContext))

        return CryptoDetailedViewModel(
            CryptoDetailedIteractor(detailedRepository, failureFactory),
            Communication.Base()
        )
    }
}