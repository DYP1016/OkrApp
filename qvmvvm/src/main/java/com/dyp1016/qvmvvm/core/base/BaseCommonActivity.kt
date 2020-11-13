package com.dyp1016.qvmvvm.core.base

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus

abstract class BaseCommonActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? = null

    open fun showOrHideLoading(isShow: Boolean) {
        if (isShow) {
            if (progressDialog == null) {
                progressDialog = ProgressDialog(this).apply {
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

    open fun useEventBus(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (useEventBus()) {
            EventBus.getDefault().unregister(this)
        }
    }

    inline fun <T : Activity> startActivity(
        clazz: Class<T>,
        code: Int? = null,
        block: Intent.() -> Unit = {}
    ) {
        val intent = Intent(this, clazz)
        initIntent(intent)
        intent.block()
        if (code != null) {
            startActivityForResult(intent, code)
        } else {
            startActivity(intent)
        }
    }

    /**
     * 初始化Intent, 可以在子类中传入通用的值
     */
    open fun initIntent(intent: Intent) {

    }
}