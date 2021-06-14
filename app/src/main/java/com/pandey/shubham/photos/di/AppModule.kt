package com.pandey.shubham.photos.di

import com.pandey.shubham.photos.BuildConfig
import com.pandey.shubham.photos.network.AuthenticateInterceptor
import com.pandey.shubham.photos.service.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthenticateInterceptor())
        .build()


    @Provides
    fun apiService(): ApiService {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}