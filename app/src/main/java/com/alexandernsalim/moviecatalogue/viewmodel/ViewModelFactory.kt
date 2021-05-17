package com.alexandernsalim.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexandernsalim.moviecatalogue.data.source.MovieRepository
import com.alexandernsalim.moviecatalogue.data.source.TvShowRepository
import com.alexandernsalim.moviecatalogue.di.Injection
import com.alexandernsalim.moviecatalogue.ui.detail.DetailMovieViewModel
import com.alexandernsalim.moviecatalogue.ui.detail.DetailTvShowViewModel
import com.alexandernsalim.moviecatalogue.ui.movie.MovieViewModel
import com.alexandernsalim.moviecatalogue.ui.tv.TvShowViewModel

class ViewModelFactory private constructor(
    private val movieRepository: MovieRepository,
    private val tvShowRepository: TvShowRepository
) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    Injection.provideMovieRepository(),
                    Injection.provideTvShowRepository()
                ).apply { instance = this }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(tvShowRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(tvShowRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}