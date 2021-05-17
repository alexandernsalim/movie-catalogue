package com.alexandernsalim.moviecatalogue.data

data class TvShowEntity (
    var id: Int,
    var title: String,
    var userScore: Double = 0.0,
    var overview: String = "",
    var firstAirDate: String = "",
    var rate: String = "",
    var duration: String = "",
    var genres: List<String> = listOf(),
    var poster: String = "",
    var seasons: List<SeasonEntity>? = null
)