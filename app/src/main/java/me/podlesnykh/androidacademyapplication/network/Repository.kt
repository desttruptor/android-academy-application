package me.podlesnykh.androidacademyapplication.network

import me.podlesnykh.androidacademyapplication.network.pojo.*
import retrofit2.http.Path

class Repository {

    suspend fun getConfiguration(): Configuration {
        return RetrofitInstance.api.getConfiguration()
    }

    suspend fun getTopRatedMoviesPage(): MoviesTopRatedPage {
        return RetrofitInstance.api.getMoviesTopRatedListByPage()
    }

    suspend fun getMovieById(id: Int): MovieDetailsItem {
        return RetrofitInstance.api.getMovieById(id)
    }
}