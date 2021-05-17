package com.alexandernsalim.moviecatalogue.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alexandernsalim.moviecatalogue.data.source.TvShowDataSource
import com.alexandernsalim.moviecatalogue.data.source.remote.RemoteDataSource
import com.alexandernsalim.moviecatalogue.data.source.remote.response.CreditsResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.PopularTvShowResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FakeTvShowRepository(private val remoteDataSource: RemoteDataSource): TvShowDataSource {

    companion object {

        private const val TAG = "FakeTvShowRepository"
    }

    override fun listPopularTvShows(): LiveData<List<TvShowEntity>> {
        val popularTvShows = MutableLiveData<List<TvShowEntity>>()

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
            }

            override fun onFailure(call: Call<PopularTvShowResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })

        return popularTvShows
    }

    override fun getTvShowDetail(tvId: Int): LiveData<TvShowEntity> {
        val tvShowDetail = MutableLiveData<TvShowEntity>()

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
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })

        return tvShowDetail
    }

    override fun getTvShowCredits(tvId: Int): LiveData<List<CastEntity>> {
        val tvShowCasts = MutableLiveData<List<CastEntity>>()

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
            }

            override fun onFailure(call: Call<CreditsResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })

        return tvShowCasts
    }
}