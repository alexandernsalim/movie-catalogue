package com.alexandernsalim.moviecatalogue.data

data class MovieEntity(
    var id: Int,
    var title: String,
    var overview: String,
    var releaseDate: String,
    var duration: String,
    var voteAverage: Double,
    var genres: List<String>,
    var poster: String
)