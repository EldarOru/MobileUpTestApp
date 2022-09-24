package com.example.mobileuptestapp.core.domain

import com.example.mobileuptestapp.core.presentation.State

interface Iteractor<T> {

    suspend fun getDataState(type: String): State<T>
}