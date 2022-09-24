package com.example.mobileuptestapp.detail.presenation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileuptestapp.core.domain.Iteractor
import com.example.mobileuptestapp.core.presentation.Communication
import com.example.mobileuptestapp.core.presentation.State
import com.example.mobileuptestapp.main.presentation.ObserveCryptoDetailed
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptoDetailedViewModel(
    private val iteractor: Iteractor<CryptoDetailedUi>,
    private val communication: Communication.Mutable<State<CryptoDetailedUi>>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel(), ObserveCryptoDetailed {

    init {
        communication.map(State.Default<CryptoDetailedUi>())
    }

    override fun observeList(owner: LifecycleOwner, observer: Observer<State<CryptoDetailedUi>>) {
        viewModelScope.launch(dispatcher) {
            communication.observe(owner, observer)
        }
    }

    suspend fun getData(id: String) {
        viewModelScope.launch(dispatcher) {
            val loadingState = State.isLoading<CryptoDetailedUi>()
            communication.map(loadingState)
            val result = iteractor.getDataState(id)
            communication.map(result)
        }
    }
}