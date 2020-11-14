package com.dyp1016.test.api

import com.dyp1016.okr.api.BaseRetrofitClient
import com.dyp1016.okr.util.NetWorkUtils
import com.dyp1016.qvmvvm.core.base.BaseApp
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient

object WanRetrofitClient : BaseRetrofitClient() {
    val service by lazy { getService(WanService::class.java, WanService.BASE_URL) }

    private val cookieJar by lazy {
        PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(BaseApp.context))
    }

    override fun handleBuilder(builder: OkHttpClient.Builder) {
        builder.cache(Cache(BaseApp.context.cacheDir, 10 * 1024 * 10))
            .cookieJar(cookieJar)
            .addInterceptor() { chain ->
                var request = chain.request()
                val netEnable = NetWorkUtils.isNetworkAvailable()

                if (!netEnable) {
                    //如果无网络, 则直接读取缓存
                    request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build()
                }

                val response = chain.proceed(request)
                if (!netEnable) {
                    val maxAge = 60 * 60
                    response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=$maxAge")
                        .build()
                } else {
                    val maxStale = 60 * 60 * 24 * 28
                    response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                        .build()
                }

                response
            }

    }
}