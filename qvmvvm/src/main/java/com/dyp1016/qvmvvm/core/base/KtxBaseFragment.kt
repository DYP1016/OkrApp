package com.dyp1016.qvmvvm.core.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class KtxBaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initData()
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun getLayoutResId(): Int

    abstract fun initView()

    abstract fun initData()

    open fun <T> createIntent(clazz: Class<T>): Intent {
        return Intent(context, clazz)
    }

    fun <T : Activity> startActivity(
        clazz: Class<T>,
        code: Int? = null,
        callback: ((intent: Intent) -> Unit)? = null
    ) {
        val intent = createIntent(clazz)
        callback?.invoke(intent)
        if (code != null) {
            startActivityForResult(intent, code)
        } else {
            startActivity(intent)
        }
    }
}