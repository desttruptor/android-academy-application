package me.podlesnykh.androidacademyapplication.domain.loadMovie

import android.content.Context
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import me.podlesnykh.androidacademyapplication.domain.movie.Movie

class LoadMovieInteractor(private val dispatcher: CoroutineDispatcher, private val context: Context) {

    suspend fun loadMovie(mutableLiveData: MutableLiveData<List<Movie>>) =
        withContext(dispatcher) {
            val moviesList = loadMovies(context)
            when {
                moviesList.isEmpty() -> LoadingResult.Error()
                else -> {
                    LoadingResult.Success()
                    mutableLiveData.value = moviesList
                }
            }
        }
}