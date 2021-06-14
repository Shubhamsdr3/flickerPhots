package com.pandey.shubham.photos

import android.app.Application
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import com.pandey.shubham.photos.di.AppComponent
import com.pandey.shubham.photos.di.AppModule
import com.pandey.shubham.photos.di.DaggerAppComponent
import com.pandey.shubham.photos.network.AuthenticateInterceptor
import com.pandey.shubham.photos.service.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {

    private var appComponent: AppComponent? = null

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthenticateInterceptor())
        .addNetworkInterceptor(StethoInterceptor())
        .build()

    private val gsonBuilder = GsonBuilder().setLenient().create()

    @JvmField
    var apiService: ApiService =
        Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .build()
            .create(ApiService::class.java)

    companion object {

        private var INSTANCE: App? = null

        fun getInstance(): App {
            if (INSTANCE == null) {
                INSTANCE = App()
            }
            return INSTANCE!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

//        appComponent = DaggerAppComponent.builder()
//                .appModule(AppModule())
//                .build()
//        appComponent?.inject(this)


    }
}