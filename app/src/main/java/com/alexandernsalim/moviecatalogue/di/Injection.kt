package com.alexandernsalim.moviecatalogue.di

import com.alexandernsalim.moviecatalogue.data.source.MovieRepository
import com.alexandernsalim.moviecatalogue.data.source.TvShowRepository
import com.alexandernsalim.moviecatalogue.data.source.remote.RemoteDataSource

object Injection {
    fun provideMovieRepository(): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieRepository.getInstance(remoteDataSource)
    }

    fun provideTvShowRepository(): TvShowRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return TvShowRepository.getInstance(remoteDataSource)
    }
}