package com.dyp1016.okr.ui

import com.dyp1016.okr.R
import com.dyp1016.okr.databinding.ActivityMainBinding
import com.dyp1016.qvmvvm.core.base.BaseVMActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseVMActivity() {
    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    private val viewModel by viewModel<MainViewModel>()

    override fun initView() {
        binding.run {
            userModel = viewModel
        }
    }

    override fun initData() {

    }

    override fun startObserve() {
        viewModel.apply {
            uiState.observe(this@MainActivity, {
                showOrHideLoading(it.isLoading)
            })
        }
    }
}