package com.dyp1016.qvmvvm.core.base

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus

abstract class KtxBaseCommonActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? = null
    protected lateinit var mContext: AppCompatActivity

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

    abstract fun onSuccess(code: Int)
    abstract fun onError(code: Int)

    open fun onShowRefresh(isShow: Boolean) {
        //显示下拉加载框, 使用到的Activity实现该方法

    }

    open fun useEventBus(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
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

    inline fun startActivity(
        clazz: Class<*>,
        code: Int? = null,
        block: Intent.() -> Unit = {}
    ) {
        val intent = Intent(this, clazz)
        initIntent(intent)
        intent.block()

        try {
            if (code != null) {
                startActivityForResult(intent, code)
            } else {
                startActivity(intent)
            }
        } catch (e: Exception) {
            logE(e)
            showToastL(e.toString())
        }
    }

    /**
     * 初始化Intent, 可以在子类中传入通用的值
     */
    open fun initIntent(intent: Intent) {

    }
}