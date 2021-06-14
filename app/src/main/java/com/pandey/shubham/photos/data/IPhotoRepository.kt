package com.pandey.shubham.photos.data

import com.pandey.shubham.photos.network.IResult
import kotlinx.coroutines.flow.Flow

interface IPhotoRepository {

    suspend fun fetchPhotoList(text: String): Flow<IResult<PhotoResponseDto>>
}