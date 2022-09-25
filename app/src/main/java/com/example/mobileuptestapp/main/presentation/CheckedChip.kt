package com.example.mobileuptestapp.main.presentation

class CheckedChip(
    private val id: Int = -1,
    val type: String = ""
) {
    fun checkId(id: Int) = this.id == id
}