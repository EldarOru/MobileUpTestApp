package com.example.mobileuptestapp.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface ObserveDataState<T> {

    fun observeData(owner: LifecycleOwner, observer: Observer<State<T>>)
}
