package com.dyp1016.okr.base

import androidx.viewbinding.ViewBinding
import com.dyp1016.okr.common.showFail
import com.dyp1016.okr.common.showSuccess
import com.dyp1016.qvmvvm.core.base.activity.KtxBaseActivity

abstract class BaseActivity<T : ViewBinding> : KtxBaseActivity<T>() {
    override fun onSuccess(code: Int) {
        showSuccess(code)
    }

    override fun onError(code: Int) {
        showFail(code)
    }
}