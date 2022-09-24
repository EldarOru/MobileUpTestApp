package com.example.mobileuptestapp.core.domain

import com.example.mobileuptestapp.core.presentation.Failure

interface FailureHandler {

    fun handle(e: Exception): Failure
}