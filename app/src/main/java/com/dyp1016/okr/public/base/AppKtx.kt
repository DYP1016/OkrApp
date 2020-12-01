package com.dyp1016.okr.public.base

import com.dyp1016.okr.viewModel.appModule
import com.dyp1016.qvmvvm.core.base.KtxBaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : KtxBaseApp() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}