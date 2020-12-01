package com.dyp1016.okr.ui

import com.dyp1016.okr.R
import com.dyp1016.okr.base.BaseVMActivity
import com.dyp1016.okr.databinding.ActivityMainBinding
import com.dyp1016.qvmvvm.core.base.KtxBaseViewModel
import com.dyp1016.test.ui.TestIndexActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseVMActivity() {
    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    private val viewModel by viewModel<MainViewModel>()

    override fun initView() {
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

    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}