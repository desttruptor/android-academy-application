package me.podlesnykh.androidacademyapplication.presentation.movies_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.podlesnykh.androidacademyapplication.domain.loadMovie.LoadMovieInteractor
import me.podlesnykh.androidacademyapplication.domain.loadMovie.LoadingResult
import me.podlesnykh.androidacademyapplication.domain.movie.Movie

class MoviesListViewModel(private val interactor: LoadMovieInteractor) : ViewModel() {

    private val _mutableMoviesList = MutableLiveData<List<Movie>>()
    val mutableMoviesList: MutableLiveData<List<Movie>> get() = _mutableMoviesList

    fun getMoviesList() {
        viewModelScope.launch {
            _mutableMoviesList.value = interactor.loadMovies()
        }
    }
}