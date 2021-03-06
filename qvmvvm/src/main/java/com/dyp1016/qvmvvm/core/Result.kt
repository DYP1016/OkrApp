package com.dyp1016.qvmvvm.core

sealed class Result<out T : Any> {


    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val code: Int) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$code]"
        }
    }
}