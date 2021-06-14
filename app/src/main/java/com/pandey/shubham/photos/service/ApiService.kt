package com.pandey.shubham.photos.service

import com.pandey.shubham.photos.data.FlickerResponseDto
import com.pandey.shubham.photos.data.PhotoResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/?method=flickr.photos.search&api_key=cdf9decc4fb166e6da265d085aa96f74&format=json&nojsoncallback=1")
    suspend fun fetchPhotoList(
        @Query("text") userEnterText: String
    ): Response<PhotoResponseDto>
}