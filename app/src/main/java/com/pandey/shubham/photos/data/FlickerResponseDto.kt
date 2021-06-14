package com.pandey.shubham.photos.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FlickerResponseDto(

    @SerializedName("photos")
    val flickerPhotos: PhotoResponseDto

): Parcelable

@Parcelize
data class PhotoResponseDto(

    @SerializedName("page")
    val pageNumber: Int = 0,

    @SerializedName("pages")
    val totalPages: Int,

    @SerializedName("perpage")
    val perPageNumberOfItem: Int,

    @SerializedName("total")
    val total: Int,

    @SerializedName("photo")
    val photoList: List<PhotoDetailDto>

): Parcelable


@Parcelize
data class PhotoDetailDto(

    @SerializedName("id")
    val photoId: String,

    @SerializedName("owner")
    val photoOwnerId: String,

    @SerializedName("secret")
    val secretId: String,

    @SerializedName("server")
    val serverId: Int,

    @SerializedName("farm")
    val farm: Int,

    @SerializedName("title")
    val photoTitle: String,

    @SerializedName("ispublic")
    val isPublic: Int,

    @SerializedName("isfriend")
    val isFriend: Int,

    @SerializedName("isfamily")
    val isFamily: Int

): Parcelable