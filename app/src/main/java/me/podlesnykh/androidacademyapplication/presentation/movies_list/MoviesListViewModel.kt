package me.podlesnykh.androidacademyapplication.presentation.movies_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.podlesnykh.androidacademyapplication.network.Repository
import me.podlesnykh.androidacademyapplication.network.pojo.MoviesTopRatedPage
import me.podlesnykh.androidacademyapplication.presentation.models.MovieListItem

class MoviesListViewModel() : ViewModel() {

    private val _mutableMoviesListPage = MutableLiveData<List<MovieListItem>>()
    val mutableMoviesListPage: MutableLiveData<List<MovieListItem>> get() = _mutableMoviesListPage

    private val repository by lazy {
        Repository()
    }

    fun getMoviesPage() {
        viewModelScope.launch {
            val page = repository.loadMoviesPage(1)
            _mutableMoviesListPage.value = page
        }
    }
}