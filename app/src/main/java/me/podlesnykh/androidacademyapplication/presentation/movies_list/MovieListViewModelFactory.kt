package me.podlesnykh.androidacademyapplication.presentation.movies_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.podlesnykh.androidacademyapplication.network.Repository

class MovieListViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MoviesListViewModel(repository) as T
        }
        throw IllegalStateException("Unknown ViewModel class")
    }
}