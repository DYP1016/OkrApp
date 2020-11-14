package com.dyp1016.okr.util

import android.content.Context
import android.net.ConnectivityManager
import com.dyp1016.qvmvvm.core.base.BaseApp

class NetWorkUtils {

    companion object {
        fun isNetworkAvailable(): Boolean {
            val manager = BaseApp.context.getSystemService(
                Context.CONNECTIVITY_SERVICE
            ) as ConnectivityManager
            val info = manager.activeNetworkInfo
            return !(null == info || !info.isAvailable)
        }
    }
}