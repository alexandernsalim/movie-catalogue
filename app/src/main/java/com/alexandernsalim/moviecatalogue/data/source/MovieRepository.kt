package com.alexandernsalim.moviecatalogue.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alexandernsalim.moviecatalogue.data.CastEntity
import com.alexandernsalim.moviecatalogue.data.MovieEntity
import com.alexandernsalim.moviecatalogue.data.source.remote.RemoteDataSource
import com.alexandernsalim.moviecatalogue.data.source.remote.response.CreditsResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.MovieDetailResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.PopularMoviesResponse
import com.alexandernsalim.moviecatalogue.retrofit.ClientConstant
import com.alexandernsalim.moviecatalogue.util.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(private val remoteDataSource: RemoteDataSource): MovieDataSource {

    companion object {
        private const val TAG = "MovieRepository"
    }

    override fun listPopularMovies(): LiveData<List<MovieEntity>> {
        val popularMovies = MutableLiveData<List<MovieEntity>>()

        EspressoIdlingResource.increment()
        remoteDataSource.getPopularMovies(object : Callback<PopularMoviesResponse> {
            override fun onResponse(
                call: Call<PopularMoviesResponse>,
                response: Response<PopularMoviesResponse>
            ) {
                if (response.isSuccessful) {
                    val movies = ArrayList<MovieEntity>()

                    response.body()?.results?.let { items ->
                        for (movie in items) {
                            val id = movie.id
                            val title = movie.title
                            val overview = movie.overview
                            val releaseDate = movie.releaseDate
                            val duration = ""
                            val genres = ArrayList<String>()
                            val voteAverage = 0.0
                            val poster = String.format(ClientConstant.IMAGE_BASE_URL_780, movie.posterPath)

                            movies.add(
                                MovieEntity(
                                    id,
                                    title,
                                    overview,
                                    releaseDate,
                                    duration,
                                    voteAverage,
                                    genres,
                                    poster
                                )
                            )
                        }
                    }
                    popularMovies.postValue(movies)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<PopularMoviesResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })

        return popularMovies
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieEntity> {
        val movieDetail = MutableLiveData<MovieEntity>()
        lateinit var movie: MovieEntity

        EspressoIdlingResource.increment()
        remoteDataSource.getMovieDetail(movieId, object : Callback<MovieDetailResponse> {
            override fun onResponse(call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { detail ->
                        val id = detail.id
                        val title = detail.title
                        val overview = detail.overview ?: "Overview is not available"
                        val releaseDate = detail.releaseDate
                        val hour = detail.runtime?.div(60) ?: 0
                        val minutes = detail.runtime?.rem(60) ?: 0
                        val duration = if (hour == 0) {
                            "${minutes}m"
                        } else {
                            "${hour}h ${minutes}m"
                        }
                        val genres = detail.genres.map { it.name }
                        val voteAverage = detail.voteAverage.times(10)
                        val poster = String.format(ClientConstant.IMAGE_BASE_URL_780, detail.posterPath)

                        movie = MovieEntity(
                            id,
                            title,
                            overview,
                            releaseDate,
                            duration,
                            voteAverage,
                            genres,
                            poster
                        )
                    }
                    movieDetail.postValue(movie)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })

        return movieDetail
    }

    override fun getMovieCredits(movieId: Int): LiveData<List<CastEntity>> {
        val movieCasts = MutableLiveData<List<CastEntity>>()

        EspressoIdlingResource.increment()
        remoteDataSource.getMovieCredits(movieId, object : Callback<CreditsResponse> {
            override fun onResponse(call: Call<CreditsResponse>, response: Response<CreditsResponse>) {
                if (response.isSuccessful) {
                    val casts = ArrayList<CastEntity>()

                    response.body()?.let { credits ->
                        for (cast in credits.cast) {
                            val name = cast.name
                            val character = cast.character
                            val profile = String.format(ClientConstant.IMAGE_BASE_URL_185, cast.profilePath)

                            casts.add(
                                CastEntity(
                                    name,
                                    character,
                                    profile
                                )
                            )
                        }
                    }
                    movieCasts.postValue(casts)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<CreditsResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })

        return movieCasts
    }
}