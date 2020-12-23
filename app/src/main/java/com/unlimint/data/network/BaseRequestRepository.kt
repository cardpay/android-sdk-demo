package com.unlimint.data.network

import com.unlimint.data.Result

abstract class BaseRequestRepository<out T>(protected val api: T) {

    protected suspend inline fun <R> makeRequest(
        crossinline block: suspend T.() -> R
    ): Result<R> = try {
        Result.Success(api.block())
    } catch (e: Exception) {
        Result.Error(e)
    }
}
