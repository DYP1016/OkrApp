package com.dyp1016.okr.ui.tab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainContentAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
    private val fragmentList = listOf(
        MainHomeFragment(),
        MainSettingsFragment(),
        MainSettingsFragment()
    )

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}