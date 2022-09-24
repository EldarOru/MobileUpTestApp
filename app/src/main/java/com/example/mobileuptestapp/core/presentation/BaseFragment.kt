package com.example.mobileuptestapp.core.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.mobileuptestapp.ShowFragment

abstract class BaseFragment <B: ViewBinding>: Fragment() {

    private var viewBinding: B? = null
    protected val binding get() = checkNotNull(viewBinding)
    protected var showFragment: ShowFragment = ShowFragment.Empty()

    protected abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = initBinding(inflater, container)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ShowFragment) {
            showFragment = context
        } else {
            throw RuntimeException("Activity must implement ShowFragment interface")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}