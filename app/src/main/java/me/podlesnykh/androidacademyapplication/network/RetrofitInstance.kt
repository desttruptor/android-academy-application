package me.podlesnykh.androidacademyapplication.network

import com.google.gson.GsonBuilder
import me.podlesnykh.androidacademyapplication.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val gson by lazy {
        GsonBuilder()
            .create()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val api: MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java)
    }
}