package me.podlesnykh.androidacademyapplication.presentation.movies_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.podlesnykh.androidacademyapplication.network.Repository

class MovieListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MoviesListViewModel() as T
        }
        throw IllegalStateException("Unknown ViewModel class")
    }
}