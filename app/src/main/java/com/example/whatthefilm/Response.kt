package com.example.whatthefilm

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Response(
    @SerializedName("results")
    val movies : List<Movie>
) : Parcelable {
    constructor() : this(mutableListOf())
}
