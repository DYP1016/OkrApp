package com.dyp1016.okr.model.api

import com.dyp1016.qvmvvm.core.Result

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
}