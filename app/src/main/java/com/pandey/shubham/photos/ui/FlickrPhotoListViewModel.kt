package com.pandey.shubham.photos.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pandey.shubham.photos.base.IBaseViewModel
import com.pandey.shubham.photos.data.FlickerResponseDto
import com.pandey.shubham.photos.data.PhotoResponseDto
import com.pandey.shubham.photos.network.IResult
import com.pandey.shubham.photos.usecases.GetPhotoListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FlickrPhotoListViewModel(private val getPhotoListUseCase: GetPhotoListUseCase): IBaseViewModel() {

    private val _photoListResponse: MutableLiveData<IResult<PhotoResponseDto>> = MutableLiveData();
    val photoResponseDto: LiveData<IResult<PhotoResponseDto>> = _photoListResponse

    fun fetchPhotoList(text: String) {
        viewModelScope.launch {
            _photoListResponse.postValue(IResult.Loading)
            getPhotoListUseCase.invoke(text)
                .catch {
                    _photoListResponse.postValue(IResult.Error(it))
                }
                .collect {
                    _photoListResponse.postValue(it)
                }
        }
    }
}