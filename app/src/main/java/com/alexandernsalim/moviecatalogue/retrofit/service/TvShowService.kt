package com.alexandernsalim.moviecatalogue.retrofit.service

import com.alexandernsalim.moviecatalogue.data.source.remote.response.CreditsResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.PopularTvShowResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowService {

    @GET("tv/popular")
    fun getPopularTvShows(@Query("api_key") apiKey: String): Call<PopularTvShowResponse>

    @GET("tv/{tv_id}")
    fun getTvShowDetail(@Path("tv_id") tvId: Int, @Query("api_key") apiKey: String): Call<TvShowDetailResponse>

    @GET("tv/{tv_id}/credits")
    fun getTvShowCredits(@Path("tv_id") tvId: Int, @Query("api_key") apiKey: String): Call<CreditsResponse>
}