package com.example.mobileuptestapp.modules

import android.content.Context
import com.example.mobileuptestapp.core.BaseResourceManager
import com.example.mobileuptestapp.core.data.RetrofitClient
import com.example.mobileuptestapp.core.domain.FailureFactory
import com.example.mobileuptestapp.core.presentation.BaseViewModel
import com.example.mobileuptestapp.core.presentation.Communication
import com.example.mobileuptestapp.main.data.CryptoRemoteDataSource
import com.example.mobileuptestapp.main.data.MainRepository
import com.example.mobileuptestapp.main.domain.MainIteractor
import com.example.mobileuptestapp.main.presentation.CryptoUi
import com.example.mobileuptestapp.main.presentation.MainViewModel

class MainModule(private val applicationContext: Context) : CreateViewModel<List<CryptoUi>> {

    override fun createViewModel(): BaseViewModel<List<CryptoUi>> {
        val service = RetrofitClient().retrofitServices
        val cryptoRemoteDataSource = CryptoRemoteDataSource(service)
        val mainRepository = MainRepository(cryptoRemoteDataSource)
        val failureFactory = FailureFactory(BaseResourceManager(applicationContext))
        return MainViewModel(
            MainIteractor(mainRepository, failureFactory),
            Communication.Base()
        )
    }
}