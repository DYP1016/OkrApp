package com.dyp1016.qvmvvm.core.base.activity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dyp1016.qvmvvm.core.base.KtxBaseView
import com.dyp1016.qvmvvm.core.base.logE
import com.dyp1016.qvmvvm.core.base.showToastL

abstract class KtxBaseCommonActivity : AppCompatActivity(), KtxBaseView {
    private var progressDialog: ProgressDialog? = null
    protected lateinit var mContext: AppCompatActivity

    override fun showOrHideLoading(isShow: Boolean) {
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

    override fun onShowRefresh(isShow: Boolean) {
        //显示下拉加载框, 使用到的Activity实现该方法

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
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