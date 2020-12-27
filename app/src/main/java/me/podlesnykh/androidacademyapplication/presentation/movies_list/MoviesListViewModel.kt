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

    private val _mutableState = MutableLiveData<State>(State.Default())
    val state: LiveData<State> get() = _mutableState

    init {
        getMoviesList()
    }

    private fun getMoviesList() {
        viewModelScope.launch {
            _mutableState.value = State.Loading()

            val movieLoadingResult = interactor.loadMovie(_mutableMoviesList)
            val newState = when (movieLoadingResult) {
                is LoadingResult.Error -> State.LoadingError()
                is LoadingResult.Success -> State.Success()
                else -> State.LoadingError()
            }

            _mutableState.value = newState
        }
    }

    sealed class State {
        class Default : State()
        class Loading : State()
        class LoadingError : State()
        class Success : State()
    }
}