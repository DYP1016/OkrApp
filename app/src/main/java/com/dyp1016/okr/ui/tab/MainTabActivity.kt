package com.dyp1016.okr.ui.tab

import androidx.viewpager2.widget.ViewPager2
import com.dyp1016.okr.base.BaseActivity
import com.dyp1016.okr.databinding.ActivityMainTabBinding
import com.dyp1016.qvmvvm.core.base.logI
import com.iammert.library.readablebottombar.ReadableBottomBar

class MainTabActivity : BaseActivity<ActivityMainTabBinding>() {

    override fun getViewBinding(): ActivityMainTabBinding {
        return ActivityMainTabBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.apply {
            vpMain.adapter = MainContentAdapter(mContext)
            vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    logI("position: $position")

                    rbbMain.selectItem(position)
                }
            })

            rbbMain.setOnItemSelectListener(object : ReadableBottomBar.ItemSelectListener {
                override fun onItemSelected(index: Int) {
                    vpMain.setCurrentItem(index, true)
                }
            })
        }
    }

    override fun initData() {

    }
}