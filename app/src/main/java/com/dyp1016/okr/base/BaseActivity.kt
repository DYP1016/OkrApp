package com.dyp1016.okr.base

import androidx.viewbinding.ViewBinding
import com.dyp1016.okr.R
import com.dyp1016.qvmvvm.core.base.KtxBaseActivity
import com.dyp1016.qvmvvm.core.base.showToast

abstract class BaseActivity<T : ViewBinding> : KtxBaseActivity<T>() {
    override fun onSuccess(code: Int) {
        showToast(getString(R.string.key_success))
    }

    override fun onError(code: Int) {
        showToast(getString(R.string.key_fail) + ": " + code)
    }
}