package com.dyp1016.qvmvvm.core.base.activity

import android.os.Bundle
import androidx.viewbinding.ViewBinding

abstract class KtxBaseActivity<T : ViewBinding> : KtxBaseCommonActivity() {
    lateinit var binding: T

    abstract fun getViewBinding(): T
    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)

        initView(savedInstanceState)
        initData()
    }
}