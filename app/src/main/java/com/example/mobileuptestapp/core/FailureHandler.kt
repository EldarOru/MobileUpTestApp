package com.example.mobileuptestapp.core

interface FailureHandler {

    fun handle(e: Exception): Failure
}