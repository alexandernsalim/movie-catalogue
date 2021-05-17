package com.alexandernsalim.moviecatalogue.retrofit

import com.alexandernsalim.moviecatalogue.retrofit.service.MovieService
import com.alexandernsalim.moviecatalogue.retrofit.service.TvShowService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientProvider {
    const val API_KEY = "c1508ea418dccd966e984264e35faf60"
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    fun provideMovieClient(): MovieService {
        return provideRetrofit().create(MovieService::class.java)
    }

    fun provideTvShowClient(): TvShowService {
        return provideRetrofit().create(TvShowService::class.java)
    }

    private fun provideLogginClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideLogginClient())
        .build()
}