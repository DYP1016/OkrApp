package com.dyp1016.okr.ui

import com.dyp1016.okr.base.BaseActivity
import com.dyp1016.okr.databinding.ActivityStartBinding
import com.dyp1016.okr.ui.tab.MainTabActivity

class StartActivity : BaseActivity<ActivityStartBinding>() {

    override fun initView() {

    }

    override fun initData() {
        window.decorView.postDelayed({
            startActivity(MainTabActivity::class.java)
            finish()
        }, 1000)
    }

    override fun getViewBinding(): ActivityStartBinding {
        return ActivityStartBinding.inflate(layoutInflater)
    }
}