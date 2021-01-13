package com.dyp1016.okr.ui.tab

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.dyp1016.okr.base.BaseActivity
import com.dyp1016.okr.databinding.ActivityMainTabBinding
import com.dyp1016.qvmvvm.core.base.logI
import com.iammert.library.readablebottombar.ReadableBottomBar

class MainTabActivity : BaseActivity<ActivityMainTabBinding>() {
    companion object {
        const val SAVE_INDEX = "save_index"
    }

    override fun getViewBinding(): ActivityMainTabBinding {
        return ActivityMainTabBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
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

            savedInstanceState?.apply {
                val index = getInt(SAVE_INDEX)
                vpMain.setCurrentItem(index, false)

                rbbMain.postDelayed({
                    rbbMain.selectItem(index)
                }, 300)
            }
        }
    }

    override fun initData() {

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(SAVE_INDEX, binding.vpMain.currentItem)
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}