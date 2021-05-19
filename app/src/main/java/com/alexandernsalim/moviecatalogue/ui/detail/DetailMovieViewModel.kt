package com.alexandernsalim.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alexandernsalim.moviecatalogue.data.CastEntity
import com.alexandernsalim.moviecatalogue.data.MovieEntity
import com.alexandernsalim.moviecatalogue.data.source.MovieRepository
import javax.inject.Inject

class DetailMovieViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {
    private var movieId: Int = 0

    fun setMovieId(movieId: Int) {
        this.movieId = movieId
    }

    fun getMovie(): LiveData<MovieEntity> = movieRepository.getMovieDetail(movieId)

    fun getCredits(): LiveData<List<CastEntity>> = movieRepository.getMovieCredits(movieId)
}