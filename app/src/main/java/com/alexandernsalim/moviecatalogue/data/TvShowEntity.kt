package com.alexandernsalim.moviecatalogue.data

data class TvShowEntity(
    var id: Int,
    var title: String,
    var firstAirDate: String,
    var duration: String,
    var voteAverage: Double,
    var genres: List<String>,
    var overview: String,
    var poster: String,
    var seasons: List<SeasonEntity>?
)