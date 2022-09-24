package com.example.mobileuptestapp.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.mobileuptestapp.main.presentation.CryptoUi

interface ObserveCrypto {

    fun observeList(owner: LifecycleOwner, observer: Observer<State<List<CryptoUi>>>)

}
