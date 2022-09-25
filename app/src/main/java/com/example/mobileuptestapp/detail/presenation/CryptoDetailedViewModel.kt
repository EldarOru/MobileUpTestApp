package com.example.mobileuptestapp.detail.presenation

import com.example.mobileuptestapp.core.domain.Iteractor
import com.example.mobileuptestapp.core.presentation.BaseViewModel
import com.example.mobileuptestapp.core.presentation.Communication
import com.example.mobileuptestapp.core.presentation.State
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CryptoDetailedViewModel<T>(
    iteractor: Iteractor<T>,
    communication: Communication.Mutable<State<T>>,
    dispatcher: CoroutineDispatcher = Dispatchers.Main
) : BaseViewModel<T>(
    iteractor, communication, dispatcher
)