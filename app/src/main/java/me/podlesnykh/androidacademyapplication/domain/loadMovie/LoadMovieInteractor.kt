package me.podlesnykh.androidacademyapplication.domain.loadMovie

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.podlesnykh.androidacademyapplication.domain.movie.Movie

class LoadMovieInteractor(private val context: Context) {

    suspend fun loadMovies(): List<Movie> =
        withContext(Dispatchers.Default) {
            loadMovies(context)
        }
}