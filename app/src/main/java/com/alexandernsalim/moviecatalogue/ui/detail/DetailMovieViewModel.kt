package com.alexandernsalim.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.alexandernsalim.moviecatalogue.data.MovieEntity
import com.alexandernsalim.moviecatalogue.util.DataDummy

class DetailMovieViewModel : ViewModel() {
    private var movieId: Int = 0

    fun setMovieId(movieId: Int) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        lateinit var movieData: MovieEntity
        val movies = DataDummy.generateDummyMovies()
        for (movie in movies) {
            if (movie.id == movieId) {
                movieData = movie
                break
            }
        }
        return movieData
    }
}