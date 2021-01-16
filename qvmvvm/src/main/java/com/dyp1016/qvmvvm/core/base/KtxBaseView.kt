package com.dyp1016.qvmvvm.core.base

import androidx.lifecycle.LifecycleOwner

interface KtxBaseView {
    fun showOrHideLoading(isShow: Boolean)
    fun onSuccess(code: Int)
    fun onError(code: Int)

    //显示下拉加载框, 使用到的Activity实现该方法
    fun onShowRefresh(isShow: Boolean)

    fun initViewModel(viewModel: KtxBaseViewModel, owner: LifecycleOwner) {
        viewModel.uiState.observe(owner) {
            it.isSuccess?.apply { onSuccess(this) }
            it.isError?.apply { onError(this) }
        }
        viewModel.showLoadingState.observe(owner) {
            it?.also { showOrHideLoading(it) }
        }
        viewModel.showRefreshState.observe(owner) {
            it?.also { onShowRefresh(it) }
        }
    }
}