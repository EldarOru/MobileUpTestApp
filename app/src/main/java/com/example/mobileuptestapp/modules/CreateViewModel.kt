package com.example.mobileuptestapp.modules

import com.example.mobileuptestapp.core.presentation.BaseViewModel

interface CreateViewModel<T> {

    fun createViewModel(): BaseViewModel<T>
}