package me.podlesnykh.androidacademyapplication.presentation.movies_list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import me.podlesnykh.androidacademyapplication.domain.loadMovie.LoadMovieInteractor
import java.lang.IllegalStateException

class MovieListViewModelFactory(val application: Application) : ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MoviesListViewModel(LoadMovieInteractor(application)) as T
        }
        throw IllegalStateException("Unknown ViewModel class")
    }
}