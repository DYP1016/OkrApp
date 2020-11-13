package com.dyp1016.qvmvvm.core.base

import android.os.Bundle

abstract class BaseActivity : BaseCommonActivity() {

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initView()
        initData()
    }
}