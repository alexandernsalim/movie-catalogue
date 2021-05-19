package com.alexandernsalim.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alexandernsalim.moviecatalogue.data.MovieEntity
import com.alexandernsalim.moviecatalogue.data.source.MovieRepository
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository): ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> = movieRepository.listPopularMovies()
}