package com.dyp1016.test.api

import com.dyp1016.test.WanResponse
import com.dyp1016.test.bean.WArticleList
import retrofit2.http.GET
import retrofit2.http.Path

interface WanService {
    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int) : WanResponse<WArticleList>

}