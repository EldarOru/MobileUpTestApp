package com.example.mobileuptestapp.core.presentation

import androidx.annotation.StringRes
import com.example.mobileuptestapp.R
import com.example.mobileuptestapp.core.ResourceManager

abstract class BaseFailure(private val resourceManager: ResourceManager) : Failure {

    @StringRes
    protected abstract fun getMessageResId(): Int

    override fun getMessage(): String = resourceManager.getString(getMessageResId())
}

class NoConnection(resourceManager: ResourceManager) : BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.no_connection
}

class ServiceUnavailable(resourceManager: ResourceManager) : BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.service_unavailable
}

class GenericError(resourceManager: ResourceManager) : BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.generic_fail_message
}