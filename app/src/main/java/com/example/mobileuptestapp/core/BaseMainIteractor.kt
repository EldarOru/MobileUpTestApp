package com.example.mobileuptestapp.core

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