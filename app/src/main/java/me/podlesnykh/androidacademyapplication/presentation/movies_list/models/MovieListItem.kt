package me.podlesnykh.androidacademyapplication.presentation.movies_list.models

import me.podlesnykh.androidacademyapplication.presentation.models.Genre

data class MovieListItem(
    val id: Int,
    val title: String,
    val genres: List<Genre>,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int,
    val runtime: Int,
    val certification: String? = null
)
