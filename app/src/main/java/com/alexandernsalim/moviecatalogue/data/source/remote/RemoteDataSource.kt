package com.alexandernsalim.moviecatalogue.data.source.remote

import com.alexandernsalim.moviecatalogue.data.source.remote.response.*
import com.alexandernsalim.moviecatalogue.retrofit.ClientProvider
import retrofit2.Callback

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getPopularMovies(callback: Callback<PopularMoviesResponse>) {
        val service = ClientProvider.provideMovieClient()
        service.getPopularMovies(ClientProvider.API_KEY).enqueue(callback)
    }

    fun getMovieDetail(movieId: Int, callback: Callback<MovieDetailResponse>) {
        val service = ClientProvider.provideMovieClient()
        service.getMovieDetail(movieId, ClientProvider.API_KEY).enqueue(callback)
    }

    fun getMovieCredits(movieId: Int, callback: Callback<CreditsResponse>) {
        val service = ClientProvider.provideMovieClient()
        service.getMovieCredits(movieId, ClientProvider.API_KEY).enqueue(callback)
    }

    fun getPopularTvShows(callback: Callback<PopularTvShowResponse>) {
        val service = ClientProvider.provideTvShowClient()
        service.getPopularTvShows(ClientProvider.API_KEY).enqueue(callback)
    }

    fun getTvShowDetail(tvId: Int, callback: Callback<TvShowDetailResponse>) {
        val service = ClientProvider.provideTvShowClient()
        service.getTvShowDetail(tvId, ClientProvider.API_KEY).enqueue(callback)
    }

    fun getTvShowsCredits(tvId: Int, callback: Callback<CreditsResponse>) {
        val service = ClientProvider.provideTvShowClient()
        service.getTvShowCredits(tvId, ClientProvider.API_KEY).enqueue(callback)
    }
}