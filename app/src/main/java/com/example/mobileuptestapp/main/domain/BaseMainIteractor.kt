package com.example.mobileuptestapp.main.domain

import com.example.mobileuptestapp.core.data.MainRepository
import com.example.mobileuptestapp.core.domain.FailureHandler
import com.example.mobileuptestapp.core.domain.MainIteractor
import com.example.mobileuptestapp.core.presentation.State
import com.example.mobileuptestapp.main.data.CryptoModel
import com.example.mobileuptestapp.main.presentation.CryptoUi
import java.lang.Exception

class BaseMainIteractor(
    private val mainRepository: MainRepository<CryptoModel>,
    private val handler: FailureHandler
) : MainIteractor<List<CryptoUi>> {

    override suspend fun getItemList(type: String): State<List<CryptoUi>> {
        return try {
            State.Loaded(mainRepository.getItemList(type).map { it.map() })
        } catch (e: Exception) {
            State.Error(handler.handle(e))
        }
    }
}