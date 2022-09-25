package com.example.mobileuptestapp.main.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileuptestapp.core.domain.Iteractor
import com.example.mobileuptestapp.core.presentation.BaseViewModel
import com.example.mobileuptestapp.core.presentation.Communication
import com.example.mobileuptestapp.core.presentation.State
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel<T>(
    iteractor: Iteractor<T>,
    communication: Communication.Mutable<State<T>>,
    dispatcher: CoroutineDispatcher = Dispatchers.Main
) : BaseViewModel<T>(
    iteractor, communication, dispatcher
)