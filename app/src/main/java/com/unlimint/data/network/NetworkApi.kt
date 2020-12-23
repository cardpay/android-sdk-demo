package com.unlimint.data.network

import com.unlimint.data.network.model.AuthResponse
import retrofit2.http.POST

interface NetworkApi {

    @POST("mobile/generate_token")
    suspend fun auth(): AuthResponse
}
