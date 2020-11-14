package com.dyp1016.okr.model.api

import com.dyp1016.qvmvvm.core.Result
import com.dyp1016.qvmvvm.core.base.QvResult
import com.dyp1016.qvmvvm.core.base.RET_SUCCESS
import com.dyp1016.test.WanResponse
import com.dyp1016.test.isSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(
        call: suspend () -> Result<T>,
        errorMessage: String
    ): Result<T> {
        return try {
            call()
        } catch (e: Exception) {
            // An exception was thrown when calling the API so we're converting this to an IOException
            Result.Error(-1)
        }
    }

    suspend fun <T : Any> executeResponse(
        response: WanResponse<T>, successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): QvResult<T> {
        return try {
            coroutineScope {
                if (response.isSuccess()) {
                    QvResult(RET_SUCCESS, response.data)
                } else {
                    QvResult(response.errorCode)
                }
            }
        } catch (e: Exception) {
            return QvResult(-1)
        }
    }
}