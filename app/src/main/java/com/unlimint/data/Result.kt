package com.unlimint.data

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    companion object {
        inline fun <T> of(f: () -> T): Result<T> = try {
            val result = f()
            if (result is Result<*>) {
                result as Result<T>
            } else {
                Success(result)
            }
        } catch (ex: Exception) {
            Error(ex)
        }
    }
}

inline fun <T, R> Result<T>.flatMap(f: (T) -> Result<R>) = try {
    when (this) {
        is Result.Success -> f(this.data)
        is Result.Error -> this
    }
} catch (e: Exception) {
    Result.Error(e)
}

inline fun <R, T> Result<T>.map(f: (T) -> R) = try {
    when (this) {
        is Result.Success -> Result.Success(f(this.data))
        is Result.Error -> this
    }
} catch (e: Exception) {
    Result.Error(e)
}

inline fun <T> Result<T>.errorMap(f: (Exception) -> Exception) = try {
    when (this) {
        is Result.Success -> this
        is Result.Error -> Result.Error(f(this.exception))
    }
} catch (e: Exception) {
    Result.Error(e)
}

inline fun <T> Result<T>.flatHandle(f: (T?, Exception?) -> Unit) {
    when (this) {
        is Result.Success -> f(this.data, null)
        is Result.Error -> f(null, this.exception)
    }
}

inline fun <T> Result<T>.doOnComplete(f: () -> Unit) {
    f()
}

inline fun <T> Result<T>.handle(success: (T) -> Unit, error: (Exception) -> Unit) {
    when (this) {
        is Result.Success -> success(this.data)
        is Result.Error -> error(this.exception)
    }
}

inline fun <T, R> Result<T>.zip(success: (T) -> R, error: (Exception) -> R): R =
    when (this) {
        is Result.Success -> success(this.data)
        is Result.Error -> error(this.exception)
    }

inline fun <T> Result<T>.doOnSuccess(f: (T) -> Unit): Result<T> = try {
    when (this) {
        is Result.Success -> {
            f(this.data)
            this
        }
        is Result.Error -> this
    }
} catch (e: Exception) {
    Result.Error(e)
}

inline fun <T> Result<T>.doOnError(f: (Exception) -> Unit): Result<T> = try {
    when (this) {
        is Result.Success -> this
        is Result.Error -> {
            f(this.exception)
            this
        }
    }
} catch (e: Exception) {
    Result.Error(e)
}

inline fun <T> Result<T>.check(f: (T) -> Boolean, noinline lazyMessage: () -> String): Result<T> = try {
    when (this) {
        is Result.Success -> {
            check(f(this.data)) { lazyMessage }
            this
        }
        is Result.Error -> this
    }
} catch (e: Exception) {
    Result.Error(e)
}
