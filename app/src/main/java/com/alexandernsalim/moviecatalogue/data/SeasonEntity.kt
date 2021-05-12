package com.alexandernsalim.moviecatalogue.data

data class SeasonEntity (
    var tvShowId: Int,
    var season: Int,
    var premieredDate: String,
    var totalEpisodes: Int,
    var overview: String
)