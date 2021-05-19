package com.alexandernsalim.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class CreditsResponse(

	@field:SerializedName("cast")
	val cast: List<CastItem>
)

data class CastItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("character")
	val character: String,

	@field:SerializedName("profile_path")
	val profilePath: String?,
)
