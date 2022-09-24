package com.example.mobileuptestapp.detail.presenation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mobileuptestapp.core.presentation.BaseFragment
import com.example.mobileuptestapp.databinding.DetailedFragmentBinding

class DetailedFragment : BaseFragment<DetailedFragmentBinding>() {

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = DetailedFragmentBinding.inflate(inflater, container, false)
}