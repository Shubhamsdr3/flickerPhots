package com.pandey.shubham.photos.data

import com.pandey.shubham.photos.network.IResult
import com.pandey.shubham.photos.network.performNetworkCall
import com.pandey.shubham.photos.service.ApiService
import kotlinx.coroutines.flow.Flow

class PhotoRepository(private val apiService: ApiService) : IPhotoRepository {

    override suspend fun fetchPhotoList(text: String): Flow<IResult<PhotoResponseDto>> {
        return performNetworkCall {
            apiService.fetchPhotoList(text)
        }
    }
}