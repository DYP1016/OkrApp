package com.dyp1016.okr.model.repository

import com.dyp1016.okr.model.api.BaseRepository
import com.dyp1016.qvmvvm.core.base.QvResult
import kotlinx.coroutines.delay

class MainMessageRepository : BaseRepository() {

    fun test1(callback: () -> Unit) {
        Thread {
            Thread.sleep(2000)
            callback()
        }.start()
    }

    suspend fun test2(): QvResult<String> {
        delay(1000)

        return QvResult("success: ${(1..50).random()}")
    }
}