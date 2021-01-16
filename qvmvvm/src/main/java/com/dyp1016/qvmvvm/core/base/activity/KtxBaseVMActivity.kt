package com.dyp1016.qvmvvm.core.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.dyp1016.qvmvvm.core.base.KtxBaseViewModel

abstract class KtxBaseVMActivity<T : ViewDataBinding>(@LayoutRes val layoutId: Int) :
    KtxBaseCommonActivity() {
    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<T>(this, layoutId).apply {
            lifecycleOwner = this@KtxBaseVMActivity
        }

        initViewModel(startObserve(), this)
        initView(savedInstanceState)
        initData()
    }

    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun initData()
    abstract fun startObserve(): KtxBaseViewModel
}