package me.podlesnykh.androidacademyapplication.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val like: Boolean,
    val posterLink: String,
    val minAge: String,
    val genre: String,
    val rating: Int,
    val reviewsCount: Int,
    val title: String,
    val duration: Int,
    val backDropPosterLink: String,
    val movieDescription: String,
    val actor1Name: String,
    val actor2Name: String,
    val actor3Name: String,
    val actor4Name: String,
    val actor1PhotoLink: String,
    val actor2PhotoLink: String,
    val actor3PhotoLink: String,
    val actor4PhotoLink: String
) : Parcelable
