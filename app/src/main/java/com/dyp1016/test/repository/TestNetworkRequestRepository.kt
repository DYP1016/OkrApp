package com.dyp1016.test.repository

import com.dyp1016.okr.model.api.BaseRepository
import com.dyp1016.qvmvvm.core.base.QvResult
import com.dyp1016.qvmvvm.core.base.RET_FAIL
import com.dyp1016.qvmvvm.core.base.RET_SUCCESS
import com.dyp1016.test.api.WanRetrofitClient
import com.dyp1016.test.bean.WArticleList
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class TestNetworkRequestRepository : BaseRepository() {
    val testUrl = "https://www.wanandroid.com/article/list/1/json"

    suspend fun test1(page: Int): QvResult<WArticleList> =
        executeResponse(WanRetrofitClient.service.getHomeArticles(page))

    fun test2(listener: (result: QvResult<String>) -> Unit) {
        val request = Request.Builder()
            .url(testUrl)
            .build()

        WanRetrofitClient.okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                listener(QvResult(RET_FAIL))
            }

            override fun onResponse(call: Call, response: Response) {
                listener(QvResult(RET_SUCCESS, response.body?.string()))
            }
        })
    }

    suspend fun test3(): QvResult<String> {
        return suspendCoroutine {
            val request = Request.Builder()
                .url(testUrl)
                .build()

            WanRetrofitClient.okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    it.resumeWithException(e)
                }

                override fun onResponse(call: Call, response: Response) {
                    it.resume(QvResult(RET_SUCCESS, response.body?.string()))
                }
            })
        }
    }
}