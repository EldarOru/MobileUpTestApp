package com.example.mobileuptestapp.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileuptestapp.ProvideMainViewModel
import com.example.mobileuptestapp.core.presentation.BaseFragment
import com.example.mobileuptestapp.databinding.MainFragmentBinding
import com.example.mobileuptestapp.detail.presenation.DetailedFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : BaseFragment<MainFragmentBinding>() {

    private lateinit var viewModel: MainViewModel<List<CryptoUi>>
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

        val stateHandler =
            MainStateHandler(progressBar, errorButton, errorTextView, recyclerView, mainAdapter)

        viewModel = (activity?.application as ProvideMainViewModel).provideMainVideModel()

        setClickListeners()

        viewModel.observeData(this) {
            stateHandler.setState(it)
        }
    }

    private fun setRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        mainAdapter = MainAdapter {
            //TODO сделать отдельный класс, к которому будем мапиться
            showFragment.show(DetailedFragment.newInstance(it.getId(), it.getName()))
        }
        recyclerView.adapter = mainAdapter
    }

    //TODO поменять
    private fun setClickListeners() {
        binding.usdChip.setOnClickListener {
            lifecycleScope.launch {
                viewModel.getData("usd")
            }
        }
        binding.eurChip.setOnClickListener {
            lifecycleScope.launch {
                viewModel.getData("eur")
            }
        }
    }
}