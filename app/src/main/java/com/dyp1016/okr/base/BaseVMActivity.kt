package com.dyp1016.okr.base

import com.dyp1016.okr.common.showFail
import com.dyp1016.okr.common.showSuccess
import com.dyp1016.qvmvvm.core.base.activity.KtxBaseVMActivity

abstract class BaseVMActivity : KtxBaseVMActivity() {
    override fun onSuccess(code: Int) {
        showSuccess(code)
    }

    override fun onError(code: Int) {
        showFail(code)
    }
}