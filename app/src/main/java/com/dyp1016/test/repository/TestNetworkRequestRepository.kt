package com.dyp1016.test.repository

import com.dyp1016.okr.model.api.BaseRepository
import com.dyp1016.qvmvvm.core.base.QvResult
import com.dyp1016.test.api.WanRetrofitClient
import com.dyp1016.test.bean.WArticleList

class TestNetworkRequestRepository : BaseRepository() {

    suspend fun test1(page: Int): QvResult<WArticleList> =
        executeResponse(WanRetrofitClient.service.getHomeArticles(page))
}