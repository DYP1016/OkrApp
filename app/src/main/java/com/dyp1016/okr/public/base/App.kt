package com.dyp1016.okr.public.base

import com.dyp1016.okr.viewModel.appModule
import com.dyp1016.qvmvvm.core.base.BaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : BaseApp() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}