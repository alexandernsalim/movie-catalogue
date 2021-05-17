package com.alexandernsalim.moviecatalogue.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alexandernsalim.moviecatalogue.data.CastEntity
import com.alexandernsalim.moviecatalogue.data.SeasonEntity
import com.alexandernsalim.moviecatalogue.data.TvShowEntity
import com.alexandernsalim.moviecatalogue.data.source.remote.RemoteDataSource
import com.alexandernsalim.moviecatalogue.data.source.remote.response.CreditsResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.PopularTvShowResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import com.alexandernsalim.moviecatalogue.util.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowRepository private constructor(private val remoteDataSource: RemoteDataSource): TvShowDataSource {

    companion object {
        private const val TAG = "TvShowRepository"

        @Volatile
        private var instance: TvShowRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): TvShowRepository =
            instance ?: synchronized(this) {
                instance ?: TvShowRepository(remoteDataSource).apply { instance = this }
            }
    }

    override fun listPopularTvShows(): LiveData<List<TvShowEntity>> {
        val popularTvShows = MutableLiveData<List<TvShowEntity>>()

        EspressoIdlingResource.increment()
        remoteDataSource.getPopularTvShows(object : Callback<PopularTvShowResponse> {
            override fun onResponse(call: Call<PopularTvShowResponse>, response: Response<PopularTvShowResponse>) {
                val tvShows = ArrayList<TvShowEntity>()

                if (response.isSuccessful) {
                    response.body()?.results?.let { items ->
                        for (tvShow in items) {
                            tvShows.add(
                                TvShowEntity(
                                    id = tvShow.id,
                                    title = tvShow.name,
                                    overview = tvShow.overview,
                                    firstAirDate = tvShow.firstAirDate,
                                    poster = "https://image.tmdb.org/t/p/w185${tvShow.posterPath}",
                                )
                            )
                        }
                    }
                    popularTvShows.postValue(tvShows)
                } else {
                    Log.d(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<PopularTvShowResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return popularTvShows
    }

    override fun getTvShowDetail(tvId: Int): LiveData<TvShowEntity> {
        val tvShowDetail = MutableLiveData<TvShowEntity>()

        EspressoIdlingResource.increment()
        remoteDataSource.getTvShowDetail(tvId, object : Callback<TvShowDetailResponse> {
            override fun onResponse(
                call: Call<TvShowDetailResponse>,
                response: Response<TvShowDetailResponse>
            ) {
                if (response.isSuccessful) {
                    lateinit var tvShow: TvShowEntity
                    val seasons = ArrayList<SeasonEntity>()

                    response.body()?.let { detail ->
                        val hour = detail.episodeRunTime[0] / 60
                        val minutes = detail.episodeRunTime[0] % 60
                        val duration = if (hour == 0) {
                            "${minutes}m"
                        } else {
                            "${hour}h ${minutes}m"
                        }

                        for (season in detail.seasons) {
                            seasons.add(
                                SeasonEntity(
                                    season.seasonNumber,
                                    season.airDate,
                                    season.episodeCount,
                                    season.overview,
                                    "https://image.tmdb.org/t/p/w780${season.posterPath}",
                                )
                            )
                        }

                        tvShow = TvShowEntity(
                            id = detail.id,
                            title = detail.name,
                            overview = detail.overview,
                            firstAirDate = detail.firstAirDate,
                            duration = duration,
                            userScore = detail.voteAverage.times(10),
                            genres = detail.genres.map { it.name },
                            poster = "https://image.tmdb.org/t/p/w780${detail.posterPath}",
                            seasons = seasons
                        )
                        tvShowDetail.postValue(tvShow)
                    }
                } else {
                    Log.d(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return tvShowDetail
    }

    override fun getTvShowCredits(tvId: Int): LiveData<List<CastEntity>> {
        val tvShowCasts = MutableLiveData<List<CastEntity>>()

        EspressoIdlingResource.increment()
        remoteDataSource.getTvShowsCredits(tvId, object : Callback<CreditsResponse> {
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
                    tvShowCasts.postValue(casts)
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

        return tvShowCasts
    }
}