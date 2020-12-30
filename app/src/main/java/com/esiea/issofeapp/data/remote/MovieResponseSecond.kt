package com.esiea.issofeapp.data.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponseSecond(
    @SerializedName("results")
    val movies : List<MovieSecond>

) : Parcelable {
    constructor() : this(mutableListOf())
}
