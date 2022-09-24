package com.example.mobileuptestapp.core.domain

import com.example.mobileuptestapp.core.presentation.State

interface MainIteractor<T> {

    suspend fun getItemList(type: String): State<T>
}