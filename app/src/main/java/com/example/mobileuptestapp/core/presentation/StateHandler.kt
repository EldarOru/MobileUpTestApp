package com.example.mobileuptestapp.core.presentation

interface StateHandler<T> {

    fun setState(state: State<T>)
}
