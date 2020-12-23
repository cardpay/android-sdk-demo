package com.unlimint.di.module

import com.unlimint.di.scope.ApplicationScope
import com.unlimint.data.RepositoryImpl
import com.unlimint.data.network.NetworkApi
import com.unlimint.domain.Repository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object AppModule {

//    private const val BASE_SERVER_URL = "https://sandbox.cardpay.com/demo-merchant/"
    private const val BASE_SERVER_URL = "https://demo-merchant.frontend.cardpay-aws.net/"


    @Provides
    @ApplicationScope
    fun provideRepository(
        networkApi: NetworkApi
    ): Repository = RepositoryImpl(networkApi)

    @Provides
    fun provideNetworkSource(): NetworkApi = Retrofit.Builder()
        .client(OkHttpClient.Builder().build())
        .baseUrl(BASE_SERVER_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(NetworkApi::class.java)
}
