package com.example.whatthefilm

import android.os.Parcelable
import android.widget.Button
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize /*The implementation of the Parcelable interface
allows an object to be passed
between the different Android components
like, activity and fragment.*/
data class Movie(

    @SerializedName("id")
    val id : String ?,
    @SerializedName("title")
    val title : String ?,
    @SerializedName("poster_path")
    val poster : String ?,
    @SerializedName("release_date")
    val release : String?,
    @SerializedName("overview")
    val overview : String?,
    @SerializedName("vote_average")
    val rating : String?,

) : Parcelable{
    constructor() : this("", "", "", "", "", "" )
}
