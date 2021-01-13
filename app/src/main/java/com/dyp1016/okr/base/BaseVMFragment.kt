package com.dyp1016.okr.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.dyp1016.okr.common.showFail
import com.dyp1016.okr.common.showSuccess
import com.dyp1016.qvmvvm.core.base.fragment.KtxBaseVMFragment

abstract class BaseVMFragment<T : ViewDataBinding>(@LayoutRes layoutId: Int) :
    KtxBaseVMFragment<T>(layoutId) {

    override fun onSuccess(code: Int) {
        showSuccess(code)
    }

    override fun onError(code: Int) {
        showFail(code)
    }
}