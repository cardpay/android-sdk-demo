package com.unlimint.domain

import com.unlimint.data.Result

interface Repository {

    suspend fun getMobileToken(): Result<String>
}
