package com.alexandernsalim.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.alexandernsalim.moviecatalogue.data.CastEntity
import com.alexandernsalim.moviecatalogue.data.MovieEntity

interface MovieDataSource {

    fun listPopularMovies(): LiveData<List<MovieEntity>>

    fun getMovieDetail(movieId: Int): LiveData<MovieEntity>

    fun getMovieCredits(movieId: Int): LiveData<List<CastEntity>>
}