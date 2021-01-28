package me.podlesnykh.androidacademyapplication.presentation.models

data class MovieListItem(
    val id: Int,
    val title: String,
    val genres: List<Genre>,
    val posterPath: String,
    val voteAverage: Int,
    val voteCount: Int,
    val runtime: Int,
    val certification: String
)
