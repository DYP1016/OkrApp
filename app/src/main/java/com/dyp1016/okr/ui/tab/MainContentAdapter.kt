package com.dyp1016.okr.ui.tab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dyp1016.okr.ui.tab.home.MainHomeFragment
import com.dyp1016.okr.ui.tab.message.MainMessageFragment
import com.dyp1016.okr.ui.tab.setting.MainSettingsFragment

class MainContentAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
    private val fragmentList = listOf(
        MainHomeFragment(),
        MainMessageFragment(),
        MainSettingsFragment()
    )

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}