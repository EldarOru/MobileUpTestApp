package com.example.mobileuptestapp.main.presentation

class CheckedChip(
    private val id: Int = -1,
    var type: String = ""
) {
    fun changeType(type: String) {
        this.type = type
    }
}