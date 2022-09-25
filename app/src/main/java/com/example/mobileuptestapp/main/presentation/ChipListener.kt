package com.example.mobileuptestapp.main.presentation

import androidx.lifecycle.LifecycleCoroutineScope
import com.google.android.material.chip.Chip
import kotlinx.coroutines.launch

sealed class ChipListener(
    private val chip: Chip,
    private val scope: LifecycleCoroutineScope
) {

    protected abstract val type: String

    fun click(viewModel: MainViewModel<List<CryptoUi>>, checkedChip: CheckedChip) {
        chip.setOnClickListener {
            scope.launch {
                viewModel.getData(type)
                checkedChip.changeType(type)
            }
        }
    }

    class USDChip(chip: Chip, scope: LifecycleCoroutineScope) :
        ChipListener(chip, scope) {

        override val type: String
            get() = "usd"

    }

    class EURChip(chip: Chip, scope: LifecycleCoroutineScope) :
        ChipListener(chip, scope) {

        override val type: String
            get() = "eur"
    }
}