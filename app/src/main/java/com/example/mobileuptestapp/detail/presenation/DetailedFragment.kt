package com.example.mobileuptestapp.detail.presenation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.mobileuptestapp.ProvideDetailedViewModel
import com.example.mobileuptestapp.ProvideMainViewModel
import com.example.mobileuptestapp.core.presentation.BaseFragment
import com.example.mobileuptestapp.databinding.DetailedFragmentBinding
import com.example.mobileuptestapp.main.presentation.MainViewModel
import kotlinx.coroutines.launch

class DetailedFragment : BaseFragment<DetailedFragmentBinding>() {

    private lateinit var viewModel: CryptoDetailedViewModel<CryptoDetailedUi>

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = DetailedFragmentBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailedStateHandler = DetailedStateHandler(
            binding.progressBar,
            binding.retryButton,
            binding.errorTv,
            InfoLayout(
                binding.infoLayout,
                binding.detailedImage,
                binding.descriptionTv,
                binding.categoryTv
            )
        )
        viewModel = (activity?.application as ProvideDetailedViewModel).provideDetailedViewModel()
        setListeners()
        setBegin()
        viewModel.observeData(this) {
            detailedStateHandler.setState(it)
        }

    }

    private fun setBegin() {
        binding.cryptoToolbarName.title = arguments?.getString(NAME)

        lifecycleScope.launch {
            arguments?.getString(KEY)?.let { viewModel.getData(it) }
        }
    }

    private fun setListeners() {
        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    companion object {
        private const val KEY = "ID"
        private const val NAME = "NAME"

        fun newInstance(value: String, name: String) = DetailedFragment().apply {
            arguments = Bundle().apply {
                putString(KEY, value)
                putString(NAME, name)
            }
        }
    }
}