package com.alexandernsalim.moviecatalogue.data

data class TvShowEntity (
    var id: Int,
    var title: String,
    var userScore: Float,
    var overview: String,
    var rate: String,
    var duration: String,
    var genres: String,
    var poster: Int,
    var seasons: List<SeasonEntity>? = null
)