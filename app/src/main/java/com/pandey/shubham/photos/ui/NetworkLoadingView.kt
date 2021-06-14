package com.pandey.shubham.photos.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.pandey.shubham.photos.base.IBaseCustomView
import com.pandey.shubham.photos.databinding.NetworkLoadingViewBinding


class NetworkLoadingView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defyStyle: Int = 0
): IBaseCustomView<NetworkLoadingViewBinding>(context, attributeSet, defyStyle) {


    override fun getViewBinding(inflater: LayoutInflater): NetworkLoadingViewBinding {
        return NetworkLoadingViewBinding.inflate(inflater)
    }
}