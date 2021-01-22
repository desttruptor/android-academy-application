package me.podlesnykh.androidacademyapplication.presentation.models

import me.podlesnykh.androidacademyapplication.network.pojo.CastItem

data class MovieItem(
    val id: Int,
    val certification: String,
    val genres: List<Genre>,
    val backdropPath: String,
    val voteAverage: Double,
    val voteCount: Int,
    val overview: String,
    val actors: List<Actor>
)
