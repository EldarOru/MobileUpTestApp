package com.example.mobileuptestapp.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileuptestapp.ProvideMainViewModel
import com.example.mobileuptestapp.core.BaseFragment
import com.example.mobileuptestapp.core.BaseStateHandler
import com.example.mobileuptestapp.databinding.MainFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : BaseFragment<MainFragmentBinding>() {

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var mainAdapter: MainAdapter

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        MainFragmentBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressBar = binding.progressBar
        val errorButton = binding.retryButton
        val errorTextView = binding.errorTv
        recyclerView = binding.cryptoRv

        setRecyclerView()

        val stateHandler = BaseStateHandler(progressBar, errorButton, errorTextView, recyclerView, mainAdapter)

        viewModel = (activity?.application as ProvideMainViewModel).provideMainVideModel()

        setClickListeners()

        viewModel.observeList(this) {
            stateHandler.setState(it)
        }
    }

    private fun setRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        mainAdapter = MainAdapter()
        recyclerView.adapter = mainAdapter
    }

    private fun setClickListeners() {
        binding.usdChip.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.getData("usd")
            }
        }
    }
}