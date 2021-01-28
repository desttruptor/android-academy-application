package me.podlesnykh.androidacademyapplication.network

import me.podlesnykh.androidacademyapplication.network.pojo.*
import me.podlesnykh.androidacademyapplication.presentation.models.Actor
import me.podlesnykh.androidacademyapplication.presentation.models.Genre
import me.podlesnykh.androidacademyapplication.presentation.models.MovieDetailedItem
import me.podlesnykh.androidacademyapplication.presentation.models.MovieListItem

class Repository {

    private suspend fun getConfiguration(): Configuration {
        return RetrofitInstance.api.getConfiguration()
    }

    private suspend fun getTopRatedMoviesPage(pageNumber: Int): MoviesTopRatedPage {
        return RetrofitInstance.api.getMoviesTopRatedListByPage(pageNumber)
    }

    private suspend fun getMovieById(id: Int): MovieDetailsItem {
        return RetrofitInstance.api.getMovieById(id)
    }

    suspend fun loadMoviesPage(pageNumber: Int): List<MovieListItem> {
        val baseUrl = getConfiguration().images?.secureBaseUrl ?: "https://image.tmdb.org/t/p/w185/"
        val page = getTopRatedMoviesPage(pageNumber)
        val moviesList = page.results

        return moviesList?.map { resultsItem ->
            val movieDetails = getMovieById(resultsItem.id)
            MovieListItem(
                id = resultsItem.id,
                title = resultsItem.title ?: "",
                genres = mapGenres(movieDetails.genres ?: emptyList()),
                posterPath = baseUrl + "w500" + resultsItem.posterPath,
                voteAverage = resultsItem.voteAverage?.div(2)?.toInt() ?: 0,
                voteCount = resultsItem.voteCount ?: 0,
                runtime = movieDetails.runtime ?: 0,
                certification = movieDetails.releaseDates?.results?.find {
                    it.iso31661 == "US"
                }?.releaseDates?.get(0)?.certification ?: ""
            )
        } ?: emptyList()
    }

    suspend fun loadMovieDetails(id: Int): MovieDetailedItem {
        val baseUrl = getConfiguration().images?.secureBaseUrl ?: "https://image.tmdb.org/t/p/w185/"
        val movieDetailsItem = getMovieById(id)

        return MovieDetailedItem(
            id = movieDetailsItem.id,
            certification = movieDetailsItem.releaseDates?.results?.find {
                it.iso31661 == "US"
            }?.releaseDates?.get(0)?.certification ?: "",
            genres = mapGenres(movieDetailsItem.genres ?: emptyList()),
            backdropPath = baseUrl + "w500" + movieDetailsItem.backdropPath,
            voteAverage = movieDetailsItem.voteAverage ?: 0.0,
            voteCount = movieDetailsItem.voteCount ?: 0,
            overview = movieDetailsItem.overview ?: "",
            actors = mapActors(movieDetailsItem.credits?.cast ?: emptyList())
        )
    }

    private fun mapGenres(genresNullable: List<GenresItem>) =
        genresNullable.map {
            Genre(it.id ?: 0, it.name ?: "")
        }

    private fun mapActors(actorsNullable: List<CastItem>): List<Actor> =
        actorsNullable.map {
            Actor(it.id ?: 0, it.name ?: "", it.profilePath ?: "")
        }
}