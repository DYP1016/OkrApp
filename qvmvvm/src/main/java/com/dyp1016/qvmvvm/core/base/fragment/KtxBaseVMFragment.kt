package com.dyp1016.qvmvvm.core.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.dyp1016.qvmvvm.core.base.KtxBaseViewModel

/**
 * Created by luyao
 * on 2019/12/27 9:39
 */
abstract class KtxBaseVMFragment<T : ViewDataBinding>(@LayoutRes val layoutId: Int) :
    KtxBaseCommonFragment() {

    lateinit var binding: T

    protected fun <T : ViewDataBinding> binding(
        inflater: LayoutInflater,
        @LayoutRes layoutId: Int,
        container: ViewGroup?
    ): T = DataBindingUtil.inflate<T>(inflater, layoutId, container, false).apply {
        lifecycleOwner = this@KtxBaseVMFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = binding(inflater, layoutId, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this

        initViewModel(startObserve(), this)
        initView(savedInstanceState)
        initData()
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun startObserve(): KtxBaseViewModel
    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun initData()
}