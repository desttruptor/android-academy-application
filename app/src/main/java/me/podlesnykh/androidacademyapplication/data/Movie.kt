package me.podlesnykh.androidacademyapplication.data

import me.podlesnykh.androidacademyapplication.R

data class Movie(
    val age: String,
    val title: String,
    val tagline: String,
    val rating: Int,
    val reviewsCount: Int,
    val duration: Int,
    val posterPath: Int
)
