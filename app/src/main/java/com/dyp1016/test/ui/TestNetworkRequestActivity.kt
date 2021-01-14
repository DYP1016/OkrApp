package com.dyp1016.test.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import com.dyp1016.okr.R
import com.dyp1016.okr.base.BaseVMActivity
import com.dyp1016.okr.common.showCommonDialog
import com.dyp1016.okr.databinding.ActivityTestNetworkRequestBinding
import com.dyp1016.qvmvvm.core.base.KtxBaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TestNetworkRequestActivity :
    BaseVMActivity<ActivityTestNetworkRequestBinding>(R.layout.activity_test_network_request) {
    private val viewModel by viewModel<TestNetworkRequestViewModel>()

    override fun initView(savedInstanceState: Bundle?) {
        binding.run {
            testNetworkViewModel = viewModel
        }
    }

    override fun initData() {
        val item = arrayOf(
            "网络请求测试1",
            "网络请求测试2",
            "网络请求测试3",
            "网络请求测试4",
            "网络请求测试5"
        )

        binding.apply {
            testNetworkLvList.adapter =
                ArrayAdapter(mContext, android.R.layout.simple_list_item_1, item)
            testNetworkLvList.setOnItemClickListener { _, _, position, _ ->
                when (item[position]) {
                    "网络请求测试1" -> {
                        viewModel.test1()
                    }
                    "网络请求测试2" -> {
                        viewModel.test2()
                    }
                    "网络请求测试3" -> {
                        viewModel.test3()
                    }
                    "网络请求测试4" -> {

                    }
                    "网络请求测试5" -> {

                    }
                }
            }
        }
    }

    override fun startObserve(): KtxBaseViewModel {
        return viewModel.apply {
            uiModel.observe(this@TestNetworkRequestActivity) {
                it.result?.also { it1 ->
                    showCommonDialog(it1)
                }
            }
        }
    }
}