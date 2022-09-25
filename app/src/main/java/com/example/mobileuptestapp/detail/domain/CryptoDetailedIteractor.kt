package com.example.mobileuptestapp.detail.domain

import com.example.mobileuptestapp.core.data.Repository
import com.example.mobileuptestapp.core.domain.FailureHandler
import com.example.mobileuptestapp.core.domain.Iteractor
import com.example.mobileuptestapp.core.presentation.State
import com.example.mobileuptestapp.detail.data.CryptoDetailedModel
import com.example.mobileuptestapp.detail.presenation.CryptoDetailedUi

class CryptoDetailedIteractor(
    private val repository: Repository<CryptoDetailedModel>,
    private val handler: FailureHandler
) : Iteractor<CryptoDetailedUi> {

    override suspend fun getDataState(type: String): State<CryptoDetailedUi> {
        return try {
            State.Loaded(repository.getData(type).map())
        } catch (e: Exception) {
            State.Error(handler.handle(e))
        }
    }
}