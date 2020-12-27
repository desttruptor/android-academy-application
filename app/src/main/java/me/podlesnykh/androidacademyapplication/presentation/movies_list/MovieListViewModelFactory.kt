package me.podlesnykh.androidacademyapplication.presentation.movies_list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import me.podlesnykh.androidacademyapplication.domain.loadMovie.LoadMovieInteractor

class MovieListViewModelFactory(val application: Application) : ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesListViewModel(LoadMovieInteractor(Dispatchers.Default, application)) as T
    }
}