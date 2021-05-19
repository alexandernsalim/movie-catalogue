package com.alexandernsalim.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowDetailResponse(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("genres")
	val genres: List<GenresItem>,

	@field:SerializedName("episode_run_time")
	val episodeRunTime: List<Int>,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("poster_path")
	val posterPath: String?,

	@field:SerializedName("seasons")
	val seasons: List<SeasonsItem>
)

data class SeasonsItem(

	@field:SerializedName("season_number")
	val seasonNumber: Int,

	@field:SerializedName("episode_count")
	val episodeCount: Int,

	@field:SerializedName("air_date")
	val airDate: String?,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("poster_path")
	val posterPath: String
)
