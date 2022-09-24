package com.example.mobileuptestapp.main.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.mobileuptestapp.core.presentation.State
import com.example.mobileuptestapp.detail.presenation.CryptoDetailedUi
import com.example.mobileuptestapp.main.presentation.CryptoUi

interface ObserveCrypto {

    fun observeList(owner: LifecycleOwner, observer: Observer<State<List<CryptoUi>>>)
}

interface ObserveCryptoDetailed {

    fun observeList(owner: LifecycleOwner, observer: Observer<State<CryptoDetailedUi>>)
}