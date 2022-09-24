package com.example.mobileuptestapp.core

interface Mapper<R, S> {

    fun map(source: S): R

    interface Unit<S> : Mapper<kotlin.Unit, S>
}


interface ToMapper<R> {

    fun map(): R
}