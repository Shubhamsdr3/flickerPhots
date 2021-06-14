package com.pandey.shubham.photos.ui

import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.pandey.shubham.photos.App
import com.pandey.shubham.photos.base.IBaseFragment
import com.pandey.shubham.photos.data.FlickerResponseDto
import com.pandey.shubham.photos.data.PhotoRepository
import com.pandey.shubham.photos.data.PhotoResponseDto
import com.pandey.shubham.photos.databinding.FragmentFlikrPhotoListBinding
import com.pandey.shubham.photos.network.IResult
import com.pandey.shubham.photos.usecases.GetPhotoListUseCase
import com.pandey.shubham.photos.util.PhotoListViewModelFactory
import com.pandey.shubham.photos.util.hide
import com.pandey.shubham.photos.util.show

class FlickerPhotoListFragment : IBaseFragment<FragmentFlikrPhotoListBinding, FlickrPhotoListViewModel>() {


    companion object {

        fun newInstance(): FlickerPhotoListFragment {
            return FlickerPhotoListFragment()
        }
    }

    override val viewModel: FlickrPhotoListViewModel by viewModels {
        PhotoListViewModelFactory(GetPhotoListUseCase(PhotoRepository(App.getInstance().apiService!!)))
    }

    override fun getViewBinding(inflater: LayoutInflater): FragmentFlikrPhotoListBinding {
        return FragmentFlikrPhotoListBinding.inflate(inflater)
    }

    override fun setupView() {
        viewModel.fetchPhotoList("tesla")
    }

    override fun setupListener() {}

    override fun setupObserver() {
        viewModel.photoResponseDto.observe(this, {
            when(it) {
                is IResult.Loading -> {
                    binding.photoNetworkLoader.show()
                }

                is IResult.Success -> {
                    binding.photoNetworkLoader.hide()
                    it.data?.let {
                        handleResponse(it)
                    }
                }
                is IResult.Error -> {
                    binding.photoNetworkLoader.hide()
                    it.throwable.printStackTrace()
                }
            }
        })
    }

    private fun handleResponse(it: PhotoResponseDto) {
        Toast.makeText(requireContext(), "Got the response: ${it}", Toast.LENGTH_SHORT).show()
    }

}