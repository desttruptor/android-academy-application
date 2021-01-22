package me.podlesnykh.androidacademyapplication.domain

import me.podlesnykh.androidacademyapplication.network.pojo.Configuration
import me.podlesnykh.androidacademyapplication.network.pojo.MovieDetailsItem
import me.podlesnykh.androidacademyapplication.network.pojo.ResultsItem
import me.podlesnykh.androidacademyapplication.presentation.models.Genre
import me.podlesnykh.androidacademyapplication.presentation.movies_list.models.MovieListItem

class MovieListItemMapper {
    fun map(
        configuration: Configuration,
        topRatedPage: List<ResultsItem>,
        detailedMovies: List<MovieDetailsItem>
    ) = topRatedPage.map { item ->
        val details = detailedMovies.find {
            it.id == item.id
        }

        MovieListItem(
            id = item.id,
            title = item.title ?: "",
            genres = details?.genres?.map {
                Genre(it.id ?: 0, it.name ?: "")
            } ?: emptyList(),
            posterPath = configuration.images?.secureBaseUrl ?: "https://image.tmdb.org/t/p/" + "w500" + item.posterPath,
            voteAverage = item.voteAverage ?: 0.0,
            voteCount = item.voteCount ?: 0,
            runtime = details?.runtime ?: 0,
            certification = details?.releaseDates?.results?.get(54)?.releaseDates?.get(0)?.certification
        )
    }
}