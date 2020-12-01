package com.dyp1016.okr.base

import com.dyp1016.okr.R
import com.dyp1016.qvmvvm.core.base.KtxBaseVMActivity
import com.dyp1016.qvmvvm.core.base.showToast

abstract class BaseVMActivity : KtxBaseVMActivity() {
    override fun onSuccess(code: Int) {
        showToast(getString(R.string.key_success))
    }

    override fun onError(code: Int) {
        showToast(getString(R.string.key_fail) + ": " + code)
    }
}