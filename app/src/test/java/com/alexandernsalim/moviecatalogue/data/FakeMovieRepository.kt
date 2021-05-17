package com.alexandernsalim.moviecatalogue.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alexandernsalim.moviecatalogue.data.source.MovieDataSource
import com.alexandernsalim.moviecatalogue.data.source.remote.RemoteDataSource
import com.alexandernsalim.moviecatalogue.data.source.remote.response.CreditsResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.MovieDetailResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.PopularMoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource): MovieDataSource {

    companion object {

        private const val TAG = "FakeMovieRepository"
    }

    override fun listPopularMovies(): LiveData<List<MovieEntity>> {
        val popularMovies = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getPopularMovies(object : Callback<PopularMoviesResponse> {
            override fun onResponse(call: Call<PopularMoviesResponse>, response: Response<PopularMoviesResponse>) {
                if (response.isSuccessful) {
                    val movies = ArrayList<MovieEntity>()

                    response.body()?.results?.let { items ->
                        for (movie in items) {
                            movies.add(
                                MovieEntity(
                                    id = movie.id,
                                    title = movie.title,
                                    overview = movie.overview,
                                    releaseDate = movie.releaseDate,
                                    poster = "https://image.tmdb.org/t/p/w185${movie.posterPath}"
                                ))
                        }
                    }
                    popularMovies.postValue(movies)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PopularMoviesResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })

        return popularMovies
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieEntity> {
        val movieDetail = MutableLiveData<MovieEntity>()
        lateinit var movie: MovieEntity

        remoteDataSource.getMovieDetail(movieId, object : Callback<MovieDetailResponse> {
            override fun onResponse(call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { detail ->
                        val hour = detail.runtime / 60
                        val minutes = detail.runtime % 60
                        val duration = if (hour == 0) {
                            "${minutes}m"
                        } else {
                            "${hour}h ${minutes}m"
                        }

                        movie = MovieEntity(
                            id = detail.id,
                            title = detail.title,
                            overview = detail.overview,
                            releaseDate = detail.releaseDate,
                            duration = duration,
                            userScore = detail.voteAverage.times(10),
                            genres = detail.genres.map { it.name },
                            poster = "https://image.tmdb.org/t/p/w780${detail.posterPath}"
                        )
                    }
                    movieDetail.postValue(movie)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })

        return movieDetail
    }

    override fun getMovieCredits(movieId: Int): LiveData<List<CastEntity>> {
        val movieCasts = MutableLiveData<List<CastEntity>>()

        remoteDataSource.getMovieCredits(movieId, object : Callback<CreditsResponse> {
            override fun onResponse(call: Call<CreditsResponse>, response: Response<CreditsResponse>) {
                if (response.isSuccessful) {
                    val casts = ArrayList<CastEntity>()

                    response.body()?.let { credits ->
                        for (cast in credits.cast) {
                            casts.add(
                                CastEntity(
                                    cast.name,
                                    cast.character,
                                    "https://image.tmdb.org/t/p/w185${cast.profilePath}"
                                )
                            )
                        }
                    }
                    movieCasts.postValue(casts)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<CreditsResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })

        return movieCasts
    }
}