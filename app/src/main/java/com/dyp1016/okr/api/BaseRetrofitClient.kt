package com.dyp1016.okr.api

import com.dyp1016.okr.common.AppConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseRetrofitClient {
    companion object {
        private const val TIME_OUT = 10
    }

    val okHttpClient: OkHttpClient
        get() {
            return OkHttpClient.Builder().run {
                if (AppConfig.debugMode) {
                    addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }

                connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                handleBuilder(this)

                build()
            }
        }

    /**
     * 自定义请求的build信息
     */
    protected abstract fun handleBuilder(builder: OkHttpClient.Builder)

    fun <T> getService(serviceClass: Class<T>, base: String): T {
        return Retrofit.Builder().run {
            client(okHttpClient)
            addConverterFactory(GsonConverterFactory.create())
            baseUrl(base)

            build().create(serviceClass)
        }
    }
}