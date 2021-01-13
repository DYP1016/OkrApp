package com.dyp1016.qvmvvm.core.base.fragment

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import androidx.fragment.app.Fragment
import com.dyp1016.qvmvvm.core.base.KtxBaseView

abstract class KtxBaseCommonFragment : Fragment(), KtxBaseView {
    private var progressDialog: ProgressDialog? = null

    override fun showOrHideLoading(isShow: Boolean) {
        if (isShow) {
            if (progressDialog == null) {
                progressDialog = ProgressDialog(context).apply {
                    setCanceledOnTouchOutside(false)
                    setProgressStyle(ProgressDialog.STYLE_SPINNER)
                }
            }
            progressDialog?.show()
        } else {
            progressDialog?.apply {
                if (isShowing) {
                    hide()
                }
            }
        }
    }

    override fun onShowRefresh(isShow: Boolean) {

    }

    open fun <T> createIntent(clazz: Class<T>): Intent {
        return Intent(context, clazz)
    }

    fun <T : Activity> startTargetActivity(
        clazz: Class<T>,
        code: Int? = null,
        callback: ((intent: Intent) -> Unit)? = null
    ) {
        val intent = createIntent(clazz)
        callback?.invoke(intent)
        if (code != null) {
            startActivityForResult(intent, code)
        } else {
            startActivity(intent)
        }
    }
}