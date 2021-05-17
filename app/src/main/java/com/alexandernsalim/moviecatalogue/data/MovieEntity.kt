package com.alexandernsalim.moviecatalogue.data

data class MovieEntity(
    var id: Int,
    var title: String,
    var userScore: Double = 0.0,
    var overview: String,
    var rate: String = "",
    var releaseDate: String,
    var duration: String = "",
    var genres: List<String> = listOf(),
    var poster: String
)