package com.pandey.shubham.photos.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pandey.shubham.photos.ui.FlickrPhotoListViewModel
import com.pandey.shubham.photos.usecases.GetPhotoListUseCase

class PhotoListViewModelFactory(private val getPhotosUseCase: GetPhotoListUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlickrPhotoListViewModel::class.java)) {
            return FlickrPhotoListViewModel(getPhotosUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}