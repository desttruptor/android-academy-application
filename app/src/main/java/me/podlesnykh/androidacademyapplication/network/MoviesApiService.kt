package me.podlesnykh.androidacademyapplication.network

import me.podlesnykh.androidacademyapplication.BuildConfig
import me.podlesnykh.androidacademyapplication.network.pojo.*
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApiService {
    @GET("3/configuration?api_key=${BuildConfig.API_KEY}")
    suspend fun getConfiguration(): Configuration

    @GET("3/movie/top_rated?api_key=${BuildConfig.API_KEY}&language=en-US&page=1")
    suspend fun getMoviesTopRatedListByPage(): MoviesTopRatedPage

    @GET("3/movie/{id}?api_key=${BuildConfig.API_KEY}&language=en-US&append_to_response=credits,release_dates")
    suspend fun getMovieById(@Path("id") movieId: Int): MovieDetailsItem
}