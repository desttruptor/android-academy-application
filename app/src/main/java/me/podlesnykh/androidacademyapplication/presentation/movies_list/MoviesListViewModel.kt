package me.podlesnykh.androidacademyapplication.presentation.movies_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.podlesnykh.androidacademyapplication.network.Repository
import me.podlesnykh.androidacademyapplication.network.pojo.MoviesTopRatedPage

class MoviesListViewModel(private val repository: Repository) : ViewModel() {

    private val _mutableMoviesListPage = MutableLiveData<MoviesTopRatedPage>()
    val mutableMoviesListPage: MutableLiveData<MoviesTopRatedPage> get() = _mutableMoviesListPage

    private val _imagesBaseUrl = MutableLiveData<String>()
    val imagesBaseUrl: MutableLiveData<String> get() = _imagesBaseUrl

    fun getConfiguration() {
        viewModelScope.launch {
            val configuration = repository.getConfiguration()
            _imagesBaseUrl.value = configuration.images?.secureBaseUrl
        }
    }

    fun getMoviesTopRatedPage() {
        viewModelScope.launch {
            val moviesPage = repository.getTopRatedMoviesPage()
            _mutableMoviesListPage.value = moviesPage
        }
    }
}