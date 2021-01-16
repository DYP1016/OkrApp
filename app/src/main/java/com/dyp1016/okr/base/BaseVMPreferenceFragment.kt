package com.dyp1016.okr.base

import androidx.preference.PreferenceFragmentCompat
import com.dyp1016.okr.common.showFail
import com.dyp1016.okr.common.showSuccess
import com.dyp1016.qvmvvm.core.base.KtxBaseView

abstract class BaseVMPreferenceFragment :
    PreferenceFragmentCompat(), KtxBaseView {

    override fun onSuccess(code: Int) {
        showSuccess(code)
    }

    override fun onError(code: Int) {
        showFail(code)
    }

    override fun showOrHideLoading(isShow: Boolean) {

    }

    override fun onShowRefresh(isShow: Boolean) {

    }
}