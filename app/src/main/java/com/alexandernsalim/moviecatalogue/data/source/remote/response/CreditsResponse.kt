package com.alexandernsalim.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class CreditsResponse(

	@field:SerializedName("id")
	val id: Int = 0,

	@field:SerializedName("cast")
	val cast: List<CastItem> = listOf(),

	@field:SerializedName("crew")
	val crew: List<CrewItem> = listOf()
)

data class CastItem(

	@field:SerializedName("cast_id")
	val castId: Int = 0,

	@field:SerializedName("character")
	val character: String = "",

	@field:SerializedName("gender")
	val gender: Int = 0,

	@field:SerializedName("credit_id")
	val creditId: String = "",

	@field:SerializedName("known_for_department")
	val knownForDepartment: String = "",

	@field:SerializedName("original_name")
	val originalName: String = "",

	@field:SerializedName("popularity")
	val popularity: Double = 0.0,

	@field:SerializedName("name")
	val name: String = "",

	@field:SerializedName("profile_path")
	val profilePath: String = "",

	@field:SerializedName("id")
	val id: Int = 0,

	@field:SerializedName("adult")
	val adult: Boolean = false,

	@field:SerializedName("order")
	val order: Int = 0
)

data class CrewItem(

	@field:SerializedName("gender")
	val gender: Int = 0,

	@field:SerializedName("credit_id")
	val creditId: String = "",

	@field:SerializedName("known_for_department")
	val knownForDepartment: String = "",

	@field:SerializedName("original_name")
	val originalName: String = "",

	@field:SerializedName("popularity")
	val popularity: Double = 0.0,

	@field:SerializedName("name")
	val name: String = "",

	@field:SerializedName("profile_path")
	val profilePath: String = "",

	@field:SerializedName("id")
	val id: Int = 0,

	@field:SerializedName("adult")
	val adult: Boolean = false,

	@field:SerializedName("department")
	val department: String = "",

	@field:SerializedName("job")
	val job: String = ""
)
