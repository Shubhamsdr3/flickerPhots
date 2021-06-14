package com.pandey.shubham.photos.usecases

import com.pandey.shubham.photos.base.IBaseUseCase
import com.pandey.shubham.photos.data.FlickerResponseDto
import com.pandey.shubham.photos.data.PhotoRepository
import com.pandey.shubham.photos.data.PhotoResponseDto
import com.pandey.shubham.photos.network.IResult
import kotlinx.coroutines.flow.Flow

class GetPhotoListUseCase(private val movieRepository: PhotoRepository) : IBaseUseCase<String, PhotoResponseDto> {

    override suspend fun invoke(input: String): Flow<IResult<PhotoResponseDto>> {
        return movieRepository.fetchPhotoList(input)
    }


}