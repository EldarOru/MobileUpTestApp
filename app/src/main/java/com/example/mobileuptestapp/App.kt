package com.example.mobileuptestapp

import android.app.Application
import com.example.mobileuptestapp.detail.presenation.CryptoDetailedUi
import com.example.mobileuptestapp.detail.presenation.CryptoDetailedViewModel
import com.example.mobileuptestapp.main.presentation.CryptoUi
import com.example.mobileuptestapp.main.presentation.MainViewModel
import com.example.mobileuptestapp.modules.DetailModule
import com.example.mobileuptestapp.modules.MainModule

class App : Application(), ProvideMainViewModel, ProvideDetailedViewModel {
    private lateinit var viewModel: MainViewModel<List<CryptoUi>>

    private lateinit var detailedViewModel: CryptoDetailedViewModel<CryptoDetailedUi>

    override fun onCreate() {
        super.onCreate()
        viewModel =
            MainModule(applicationContext).createViewModel() as MainViewModel<List<CryptoUi>>
        detailedViewModel =
            DetailModule(applicationContext).createViewModel() as CryptoDetailedViewModel<CryptoDetailedUi>
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