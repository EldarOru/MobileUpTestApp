package com.example.mobileuptestapp.core.domain

import com.example.mobileuptestapp.core.ResourceManager
import com.example.mobileuptestapp.core.presentation.GenericError
import com.example.mobileuptestapp.core.presentation.NoConnection
import com.example.mobileuptestapp.core.presentation.ServiceUnavailable

class FailureFactory(private val resourceManager: ResourceManager) : FailureHandler {
    override fun handle(e: Exception) = when (e) {
        is NoConnectionException -> NoConnection(resourceManager)
        is ServiceUnavailableException -> ServiceUnavailable(resourceManager)
        else -> GenericError(resourceManager)
    }
}