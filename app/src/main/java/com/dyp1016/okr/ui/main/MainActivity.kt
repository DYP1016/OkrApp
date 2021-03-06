package com.dyp1016.okr.ui.main

import android.os.Bundle
import com.dyp1016.okr.R
import com.dyp1016.okr.base.BaseVMActivity
import com.dyp1016.okr.databinding.ActivityMainBinding
import com.dyp1016.qvmvvm.core.base.KtxBaseViewModel
import com.dyp1016.test.ui.TestIndexActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseVMActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel by viewModel<MainViewModel>()

    override fun initView(savedInstanceState: Bundle?) {
        binding.run {
            userModel = viewModel
        }

        binding.mainBtTest.setOnClickListener {
            startActivity(TestIndexActivity::class.java)
        }
    }

    override fun initData() {

    }

    override fun startObserve(): KtxBaseViewModel {
        return viewModel
    }
}