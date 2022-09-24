package com.example.mobileuptestapp.detail.domain

import com.example.mobileuptestapp.core.data.SingleRepository
import com.example.mobileuptestapp.core.domain.FailureHandler
import com.example.mobileuptestapp.core.domain.Iteractor
import com.example.mobileuptestapp.core.presentation.State
import com.example.mobileuptestapp.detail.data.CryptoDetailedModel
import com.example.mobileuptestapp.detail.presenation.CryptoDetailedUi
import com.example.mobileuptestapp.main.presentation.CryptoUi
import java.lang.Exception

class CryptoDetailedIteractor(
    private val repository: SingleRepository<CryptoDetailedModel>,
    private val handler: FailureHandler
) : Iteractor<CryptoDetailedUi> {

    override suspend fun getDataState(type: String): State<CryptoDetailedUi>{
        return try {
            State.Loaded(repository.getItem(type).map())
        } catch (e: Exception) {
            State.Error(handler.handle(e))
        }
    }
}