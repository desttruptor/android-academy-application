package me.podlesnykh.androidacademyapplication.presentation.models

data class MovieDetailedItem(
    val id: Int,
    val certification: String,
    val genres: List<Genre>,
    val backdropPath: String,
    val voteAverage: Double,
    val voteCount: Int,
    val overview: String,
    val actors: List<Actor>
)
