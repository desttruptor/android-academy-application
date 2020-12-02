package me.podlesnykh.androidacademyapplication.data

import me.podlesnykh.androidacademyapplication.R

object MovieStorage {
    fun getMovies(): List<Movie> =
        listOf<Movie>(
            Movie(
                age = "13+",
                title = "Avengers: End Game",
                tagline = "Action, Adventure, Drama",
                rating = 4,
                reviewsCount = 125,
                duration = 137,
                posterPath = R.drawable.avengers_end_game
            ),
            Movie(
                age = "16+",
                title = "Tenet",
                tagline = "Action, Sci-Fi, Thriller",
                rating = 5,
                reviewsCount = 98,
                duration = 97,
                posterPath = R.drawable.tenet
            ),
            Movie(
                age = "13+",
                title = "Black Widow",
                tagline = "Action, Adventure, Sci-Fi",
                rating = 4,
                reviewsCount = 38,
                duration = 102,
                posterPath = R.drawable.black_widow
            ),
            Movie(
                age = "13+",
                title = "Wonder Woman 1984",
                tagline = "Action, Adventure, Fantasy",
                rating = 5,
                reviewsCount = 74,
                duration = 120,
                posterPath = R.drawable.wonder_woman_1984
            )
        )
}