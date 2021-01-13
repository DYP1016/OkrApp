package com.dyp1016.qvmvvm.core.base.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class KtxBaseFragment<T : ViewBinding> : KtxBaseCommonFragment() {
    var binding: T? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getViewBinding(inflater, container).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(savedInstanceState)
        initData()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


    abstract fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): T

    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun initData()
}