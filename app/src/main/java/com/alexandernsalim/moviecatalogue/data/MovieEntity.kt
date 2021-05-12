package com.alexandernsalim.moviecatalogue.data

data class MovieEntity(
    var id: Int,
    var title: String,
    var userScore: Float,
    var overview: String,
    var rate: String,
    var releaseDate: String,
    var duration: String,
    var genres: String,
    var poster: Int
)