package com.dyp1016.qvmvvm.core.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus

abstract class BaseActivity : AppCompatActivity() {

    open fun useEventBus(): Boolean {
        return false
    }

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }
        initView()
        initData()
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