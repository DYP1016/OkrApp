package com.dyp1016.qvmvvm.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class KtxBaseVMActivity : KtxBaseCommonActivity() {

    protected inline fun <reified T : ViewDataBinding> binding(
        @LayoutRes resId: Int
    ): Lazy<T> = lazy {
        DataBindingUtil.setContentView<T>(this, resId).apply {
            lifecycleOwner = this@KtxBaseVMActivity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = startObserve()
        viewModel.uiState.observe(this) {
            it.isLoading?.apply { showOrHideLoading(this) }
            it.isRefresh?.apply { onShowRefresh(this) }
            it.isSuccess?.apply { onSuccess(this) }
            it.isError?.apply { onError(this) }
        }

        initView(savedInstanceState)
        initData()
    }

    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun initData()
    abstract fun startObserve(): KtxBaseViewModel
}