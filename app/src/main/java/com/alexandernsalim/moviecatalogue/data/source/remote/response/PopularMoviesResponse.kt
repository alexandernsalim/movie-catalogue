package com.alexandernsalim.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class PopularMoviesResponse(

	@field:SerializedName("page")
	val page: Int = 1,

	@field:SerializedName("total_pages")
	val totalPages: Int = 1,

	@field:SerializedName("results")
	val results: List<ResultsItem>,

	@field:SerializedName("total_results")
	val totalResults: Int
)

data class ResultsItem(

	@field:SerializedName("overview")
	val overview: String = "",

	@field:SerializedName("original_language")
	val originalLanguage: String = "",

	@field:SerializedName("original_title")
	val originalTitle: String = "",

	@field:SerializedName("video")
	val video: Boolean = false,

	@field:SerializedName("title")
	val title: String = "",

	@field:SerializedName("genre_ids")
	val genreIds: List<Int> = listOf(),

	@field:SerializedName("poster_path")
	val posterPath: String = "",

	@field:SerializedName("backdrop_path")
	val backdropPath: String = "",

	@field:SerializedName("release_date")
	val releaseDate: String = "",

	@field:SerializedName("popularity")
	val popularity: Double = 0.0,

	@field:SerializedName("vote_average")
	val voteAverage: Double = 0.0,

	@field:SerializedName("id")
	val id: Int = 0,

	@field:SerializedName("adult")
	val adult: Boolean = false,

	@field:SerializedName("vote_count")
	val voteCount: Int = 0
)
