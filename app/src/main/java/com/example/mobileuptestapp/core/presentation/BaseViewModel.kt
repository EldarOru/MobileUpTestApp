package com.example.mobileuptestapp.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileuptestapp.core.domain.Iteractor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel<T>(
    private val iteractor: Iteractor<T>,
    private val communication: Communication.Mutable<State<T>>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel(), ObserveDataState<T> {

    init {
        communication.map(State.Default())
    }

    override fun observeData(owner: LifecycleOwner, observer: Observer<State<T>>) {
        viewModelScope.launch(dispatcher) {
            communication.observe(owner, observer)
        }
    }

    suspend fun getData(type: String) {
        viewModelScope.launch(dispatcher) {
            val loadingState = State.IsLoading<T>()
            communication.map(loadingState)
            val result = iteractor.getDataState(type)
            communication.map(result)
        }
    }
}