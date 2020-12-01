package com.dyp1016.qvmvvm.core.base

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

open class KtxBaseApp : Application() {
    companion object {
        var context: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()

        context = applicationContext
    }
}