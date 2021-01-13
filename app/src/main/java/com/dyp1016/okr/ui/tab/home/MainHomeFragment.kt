package com.dyp1016.okr.ui.tab.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dyp1016.okr.base.BaseFragment
import com.dyp1016.okr.databinding.FragmentMainHomeBinding
import com.dyp1016.okr.ui.main.MainActivity

class MainHomeFragment : BaseFragment<FragmentMainHomeBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainHomeBinding {
        return FragmentMainHomeBinding.inflate(inflater, container, false)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding?.apply {
            btTest.setOnClickListener { startTargetActivity(MainActivity::class.java) }
        }
    }

    override fun initData() {

    }
}