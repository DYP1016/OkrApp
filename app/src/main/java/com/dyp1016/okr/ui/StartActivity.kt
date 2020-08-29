package com.dyp1016.okr.ui

import com.dyp1016.okr.R
import com.dyp1016.qvmvvm.core.base.BaseActivity

class StartActivity : BaseActivity() {
    override fun getLayoutResId(): Int {
        return R.layout.activity_start
    }

    override fun initView() {

    }

    override fun initData() {
        window.decorView.postDelayed({ startActivity(MainActivity::class.java) }, 1000)
    }
}