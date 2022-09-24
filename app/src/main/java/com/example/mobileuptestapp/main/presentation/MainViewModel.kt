package com.example.mobileuptestapp.main.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileuptestapp.core.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainIteractor: MainIteractor<List<CryptoUi>>,
    private val communication: Communication.Mutable<State<List<CryptoUi>>>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel(), ObserveCrypto {

    init {
        communication.map(State.Default<List<CryptoUi>>())
    }

    override fun observeList(owner: LifecycleOwner, observer: Observer<State<List<CryptoUi>>>) {
        viewModelScope.launch(dispatcher) {
            communication.observe(owner, observer)
        }
    }

    suspend fun getData(type: String) {
        viewModelScope.launch(dispatcher) {
            val loadingState = State.isLoading<List<CryptoUi>>()
            communication.map(loadingState)
            val result = mainIteractor.getItemList(type)
            communication.map(result)
        }
    }
}