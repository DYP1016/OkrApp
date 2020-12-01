package com.dyp1016.qvmvvm.core.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding

abstract class KtxBaseActivity<T : ViewBinding> : KtxBaseCommonActivity() {
    lateinit var binding: T

    abstract fun getViewBinding(): T
    abstract fun initView()
    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)

        initView()
        initData()
    }
}