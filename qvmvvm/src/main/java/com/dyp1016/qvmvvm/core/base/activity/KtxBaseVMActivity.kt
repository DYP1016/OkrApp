package com.dyp1016.qvmvvm.core.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.dyp1016.qvmvvm.core.base.KtxBaseViewModel

abstract class KtxBaseVMActivity<T : ViewDataBinding>(@LayoutRes val layoutId: Int) :
    KtxBaseCommonActivity() {
    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<T>(this, layoutId).apply {
            lifecycleOwner = this@KtxBaseVMActivity
        }

        val viewModel = startObserve()
        viewModel.uiState.observe(this) {
            it.isSuccess?.apply { onSuccess(this) }
            it.isError?.apply { onError(this) }
        }
        viewModel.showLoadingState.observe(this) {
            it?.also { showOrHideLoading(it) }
        }
        viewModel.showRefreshState.observe(this) {
            it?.also { onShowRefresh(it) }
        }

        initView(savedInstanceState)
        initData()
    }

    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun initData()
    abstract fun startObserve(): KtxBaseViewModel
}