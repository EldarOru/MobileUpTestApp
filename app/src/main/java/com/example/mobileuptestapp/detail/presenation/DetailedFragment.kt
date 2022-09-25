package com.example.mobileuptestapp.detail.presenation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.mobileuptestapp.ProvideDetailedViewModel
import com.example.mobileuptestapp.core.presentation.BaseFragment
import com.example.mobileuptestapp.databinding.DetailedFragmentBinding
import com.example.mobileuptestapp.main.presentation.CryptoTransfer
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
            binding.errorImg,
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
        val cryptoTransfer = arguments?.getParcelable<CryptoTransfer>(OBJ)
        binding.cryptoToolbarName.title = cryptoTransfer?.getName()

        lifecycleScope.launch {
            cryptoTransfer?.getId()?.let { viewModel.getData(it) }
        }
    }

    private fun setListeners() {
        val cryptoTransfer = arguments?.getParcelable<CryptoTransfer>(OBJ)
        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.retryButton.setOnClickListener {
            lifecycleScope.launch {
                cryptoTransfer?.getId()?.let { viewModel.getData(it) }
            }
        }
    }

    companion object {
        private const val OBJ = "obj"

        fun newInstance(cryptoTransfer: CryptoTransfer) = DetailedFragment().apply {
            arguments = Bundle().apply {
                putParcelable(OBJ, cryptoTransfer)
            }
        }
    }
}