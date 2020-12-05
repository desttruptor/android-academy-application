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
    val actorNames: List<String>,
    val actorPhotoLinks: List<String>
) : Parcelable
