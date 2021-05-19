package com.alexandernsalim.moviecatalogue.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alexandernsalim.moviecatalogue.data.source.TvShowDataSource
import com.alexandernsalim.moviecatalogue.data.source.remote.RemoteDataSource
import com.alexandernsalim.moviecatalogue.data.source.remote.response.CreditsResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.PopularTvShowResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import com.alexandernsalim.moviecatalogue.retrofit.ClientConstant
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
                            val id = tvShow.id
                            val title = tvShow.name
                            val overview = tvShow.overview
                            val firstAirDate = tvShow.firstAirDate
                            val duration = ""
                            val voteAverage = 0.0
                            val genres = ArrayList<String>()
                            val poster = String.format(ClientConstant.IMAGE_BASE_URL_185, tvShow.posterPath)
                            val seasons = null

                            tvShows.add(
                                TvShowEntity(
                                    id,
                                    title,
                                    firstAirDate,
                                    duration,
                                    voteAverage,
                                    genres,
                                    overview,
                                    poster,
                                    seasons
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
                        val id = detail.id
                        val title = detail.name
                        val overview = detail.overview
                        val firstAirDate = detail.firstAirDate
                        val hour = if (detail.episodeRunTime.isEmpty()) {
                            0
                        } else {
                            detail.episodeRunTime[0] / 60
                        }
                        val minutes = if (detail.episodeRunTime.isEmpty()) {
                            0
                        } else {
                            detail.episodeRunTime[0] % 60
                        }
                        val duration = if (hour == 0) {
                            "${minutes}m"
                        } else {
                            "${hour}h ${minutes}m"
                        }
                        val voteAverage = detail.voteAverage.times(10)
                        val genres = detail.genres.map { it.name }
                        val poster = String.format(ClientConstant.IMAGE_BASE_URL_780, detail.posterPath)

                        for (season in detail.seasons) {
                            val seasonNumber = season.seasonNumber
                            val premieredDate = season.airDate ?: "TBA"
                            val totalEpisodes = season.episodeCount
                            val seasonOverview = season.overview
                            val seasonPoster = String.format(ClientConstant.IMAGE_BASE_URL_780, season.posterPath)

                            seasons.add(
                                SeasonEntity(
                                    seasonNumber,
                                    premieredDate,
                                    totalEpisodes,
                                    seasonOverview,
                                    seasonPoster
                                )
                            )
                        }

                        tvShow = TvShowEntity(
                            id,
                            title,
                            firstAirDate,
                            duration,
                            voteAverage,
                            genres,
                            overview,
                            poster,
                            seasons
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