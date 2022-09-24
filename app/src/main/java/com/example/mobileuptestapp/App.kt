package com.example.mobileuptestapp

import android.app.Application
import com.example.mobileuptestapp.core.*
import com.example.mobileuptestapp.main.presentation.CryptoUi
import com.example.mobileuptestapp.main.presentation.MainViewModel

class App: Application(), ProvideMainViewModel {
    private lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()

        val cryptoRemoveDataSource = CryptoRemoveDataSource(RetrofitClient().retrofitServices)
        val baseMainRepository = BaseMainRepository(cryptoRemoveDataSource)
        val failureFactory = FailureFactory(BaseResourceManager(applicationContext))
        viewModel = MainViewModel(
            BaseMainIteractor(baseMainRepository, failureFactory),
            Communication.Base<State<List<CryptoUi>>>()
        )
    }

    override fun provideMainVideModel() = viewModel
}

interface ProvideMainViewModel {

    fun provideMainVideModel(): MainViewModel
}