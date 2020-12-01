package com.dyp1016.okr.ui

import com.dyp1016.okr.base.BaseActivity
import com.dyp1016.okr.databinding.ActivityStartBinding

class StartActivity : BaseActivity<ActivityStartBinding>() {

    override fun initView() {

    }

    override fun initData() {
        window.decorView.postDelayed({
            startActivity(MainActivity::class.java)
            finish()
        }, 1000)
    }

    override fun getViewBinding(): ActivityStartBinding {
        return ActivityStartBinding.inflate(layoutInflater)
    }
}