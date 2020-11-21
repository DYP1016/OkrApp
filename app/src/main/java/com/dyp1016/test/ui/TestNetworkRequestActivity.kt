package com.dyp1016.test.ui

import android.widget.ArrayAdapter
import com.dyp1016.okr.R
import com.dyp1016.okr.common.showCommonDialog
import com.dyp1016.okr.common.showResult
import com.dyp1016.okr.databinding.ActivityTestNetworkRequestBinding
import com.dyp1016.qvmvvm.core.base.BaseVMActivity
import kotlinx.android.synthetic.main.activity_test_network_request.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TestNetworkRequestActivity : BaseVMActivity() {
    private val binding by binding<ActivityTestNetworkRequestBinding>(
        R.layout.activity_test_network_request
    )
    private val viewModel by viewModel<TestNetworkRequestViewModel>()

    override fun initView() {
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

        test_network_lv_list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)
        test_network_lv_list.setOnItemClickListener { _, _, position, _ ->
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

    override fun startObserve() {
        viewModel.apply {
            uiModel.observe(this@TestNetworkRequestActivity) {
                showOrHideLoading(it.isLoading)

                it.result?.also { it1 ->
                    showCommonDialog(it1)
                }

                it.isError?.apply { showResult(this) }
            }
        }
    }
}