package com.dyp1016.qvmvvm.core.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
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

    protected open fun hideSoftInput() {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(window.decorView.windowToken, 0)
    }

    fun <T : Activity> startActivity(
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

    open fun <T> createIntent(clazz: Class<T>): Intent {
        return Intent(this, clazz)
    }
}