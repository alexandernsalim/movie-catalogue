package com.alexandernsalim.moviecatalogue.data.source.remote

import com.alexandernsalim.moviecatalogue.data.source.remote.response.*
import com.alexandernsalim.moviecatalogue.retrofit.ClientConstant
import com.alexandernsalim.moviecatalogue.retrofit.service.MovieService
import com.alexandernsalim.moviecatalogue.retrofit.service.TvShowService
import retrofit2.Callback
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val movieService: MovieService,
    private val tvShowService: TvShowService
) {

    fun getPopularMovies(callback: Callback<PopularMoviesResponse>) {
        movieService.getPopularMovies(ClientConstant.API_KEY).enqueue(callback)
    }

    fun getMovieDetail(movieId: Int, callback: Callback<MovieDetailResponse>) {
        movieService.getMovieDetail(movieId, ClientConstant.API_KEY).enqueue(callback)
    }

    fun getMovieCredits(movieId: Int, callback: Callback<CreditsResponse>) {
        movieService.getMovieCredits(movieId, ClientConstant.API_KEY).enqueue(callback)
    }

    fun getPopularTvShows(callback: Callback<PopularTvShowResponse>) {
        tvShowService.getPopularTvShows(ClientConstant.API_KEY).enqueue(callback)
    }

    fun getTvShowDetail(tvId: Int, callback: Callback<TvShowDetailResponse>) {
        tvShowService.getTvShowDetail(tvId, ClientConstant.API_KEY).enqueue(callback)
    }

    fun getTvShowsCredits(tvId: Int, callback: Callback<CreditsResponse>) {
        tvShowService.getTvShowCredits(tvId, ClientConstant.API_KEY).enqueue(callback)
    }
}