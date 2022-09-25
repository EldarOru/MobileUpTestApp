package com.example.mobileuptestapp

import android.app.Application
import com.example.mobileuptestapp.core.BaseResourceManager
import com.example.mobileuptestapp.core.data.RetrofitClient
import com.example.mobileuptestapp.core.domain.FailureFactory
import com.example.mobileuptestapp.core.presentation.Communication
import com.example.mobileuptestapp.core.presentation.State
import com.example.mobileuptestapp.detail.data.CryptoDetailedRemoteDataSource
import com.example.mobileuptestapp.detail.data.CryptoDetailedRepository
import com.example.mobileuptestapp.detail.domain.CryptoDetailedIteractor
import com.example.mobileuptestapp.detail.presenation.CryptoDetailedUi
import com.example.mobileuptestapp.detail.presenation.CryptoDetailedViewModel
import com.example.mobileuptestapp.main.data.CryptoRemoteDataSource
import com.example.mobileuptestapp.main.data.MainRepository
import com.example.mobileuptestapp.main.domain.MainIteractor
import com.example.mobileuptestapp.main.presentation.CryptoUi
import com.example.mobileuptestapp.main.presentation.MainViewModel

class App : Application(), ProvideMainViewModel, ProvideDetailedViewModel {
    private lateinit var viewModel: MainViewModel<List<CryptoUi>>

    private lateinit var detailedViewModel: CryptoDetailedViewModel<CryptoDetailedUi>

    override fun onCreate() {
        super.onCreate()

        val service = RetrofitClient().retrofitServices
        //TODO отдельный класс для всей этой генерации
        val cryptoRemoteDataSource = CryptoRemoteDataSource(service)
        val mainRepository = MainRepository(cryptoRemoteDataSource)
        val failureFactory = FailureFactory(BaseResourceManager(applicationContext))
        viewModel = MainViewModel(
            MainIteractor(mainRepository, failureFactory),
            Communication.Base<State<List<CryptoUi>>>()
        )

        val cryptoDetailedDataSource = CryptoDetailedRemoteDataSource(service)
        val detailedRepository = CryptoDetailedRepository(cryptoDetailedDataSource)

        detailedViewModel = CryptoDetailedViewModel(
            CryptoDetailedIteractor(detailedRepository, failureFactory),
            Communication.Base<State<CryptoDetailedUi>>()
        )
    }

    override fun provideMainVideModel() = viewModel

    override fun provideDetailedViewModel() = detailedViewModel
}

interface ProvideMainViewModel {

    fun provideMainVideModel(): MainViewModel<List<CryptoUi>>
}

interface ProvideDetailedViewModel {

    fun provideDetailedViewModel(): CryptoDetailedViewModel<CryptoDetailedUi>
}