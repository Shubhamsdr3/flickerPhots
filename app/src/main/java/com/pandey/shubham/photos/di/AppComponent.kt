package com.pandey.shubham.photos.di

import com.pandey.shubham.photos.App
import com.pandey.shubham.photos.service.ApiService
import dagger.Component
import javax.inject.Singleton


@ApplicationScope
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun apiService(): ApiService

    fun inject(app: App)

}