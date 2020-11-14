package com.dyp1016.test

data class WanResponse<T>(val errorCode: Int, val errorMsg: String, val data: T)

fun WanResponse<*>.isSuccess() = errorCode != -1
