package com.dyp1016.qvmvvm.core.base

interface KtxBaseView {
    fun showOrHideLoading(isShow: Boolean)
    fun onSuccess(code: Int)
    fun onError(code: Int)

    //显示下拉加载框, 使用到的Activity实现该方法
    fun onShowRefresh(isShow: Boolean)
}