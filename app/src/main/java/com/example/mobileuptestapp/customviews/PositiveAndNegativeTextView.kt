package com.example.mobileuptestapp.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.mobileuptestapp.R

class PositiveAndNegativeTextView(context: Context, attributeSet: AttributeSet) :
    AppCompatTextView(context, attributeSet) {

    fun setText(number: Double) {
        if (number < 0) setTextColor(ContextCompat.getColor(context, R.color.red))
        else setTextColor(ContextCompat.getColor(context, R.color.green))
        text = number.toString() + " %"
    }
}