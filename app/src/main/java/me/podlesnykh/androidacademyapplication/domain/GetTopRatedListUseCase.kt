package me.podlesnykh.androidacademyapplication.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.podlesnykh.androidacademyapplication.network.Repository
import me.podlesnykh.androidacademyapplication.network.pojo.MoviesTopRatedPage
import me.podlesnykh.androidacademyapplication.presentation.movies_list.models.MovieListItem

class GetTopRatedListUseCase(private val page: Int) {
    private val repository = Repository()

}