package com.dyp1016.okr.ui.tab.message

import android.os.Bundle
import com.dyp1016.okr.R
import com.dyp1016.okr.base.BaseVMFragment
import com.dyp1016.okr.databinding.FragmentMainMessageBinding
import com.dyp1016.qvmvvm.core.base.KtxBaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainMessageFragment :
    BaseVMFragment<FragmentMainMessageBinding>(R.layout.fragment_main_message) {
    private val viewModel by viewModel<MainMessageViewModel>()

    override fun initView(savedInstanceState: Bundle?) {
        binding.apply {
            tvText.setOnClickListener { viewModel.test1() }
            tvText.setOnLongClickListener {
                viewModel.test2()
                true
            }
        }
    }

    override fun initData() {

    }

    override fun startObserve(): KtxBaseViewModel {
        viewModel.testResult.observe(this) {
            it?.apply {
                binding.tvText.text = result
            }
        }

        return viewModel
    }
}