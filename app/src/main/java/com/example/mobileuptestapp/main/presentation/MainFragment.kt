package com.example.mobileuptestapp.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobileuptestapp.core.BaseFragment
import com.example.mobileuptestapp.databinding.MainFragmentBinding

class MainFragment : BaseFragment<MainFragmentBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        MainFragmentBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}