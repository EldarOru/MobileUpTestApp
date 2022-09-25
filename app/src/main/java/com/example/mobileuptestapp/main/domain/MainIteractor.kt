package com.example.mobileuptestapp.main.domain

import com.example.mobileuptestapp.core.data.Repository
import com.example.mobileuptestapp.core.domain.FailureHandler
import com.example.mobileuptestapp.core.domain.Iteractor
import com.example.mobileuptestapp.core.presentation.State
import com.example.mobileuptestapp.main.data.CryptoModel
import com.example.mobileuptestapp.main.presentation.CryptoUi
import java.lang.Exception

class MainIteractor(
    private val repository: Repository<List<CryptoModel>>,
    private val handler: FailureHandler
) : Iteractor<List<CryptoUi>> {

    override suspend fun getDataState(type: String): State<List<CryptoUi>> {
        return try {
            State.Loaded(repository.getData(type).map { it.map(type) })
        } catch (e: Exception) {
            State.Error(handler.handle(e))
        }
    }
}