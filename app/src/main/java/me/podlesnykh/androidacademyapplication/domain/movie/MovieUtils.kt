package me.podlesnykh.androidacademyapplication.domain.movie

fun formatGenres(movie: Movie): String {
    var result = ""
    for (genre in movie.genres) {
        result += genre.name + ", "
    }
    return result.substring(0, result.length - 2).trim()
}