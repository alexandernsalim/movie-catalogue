package com.alexandernsalim.moviecatalogue.di.component

import com.alexandernsalim.moviecatalogue.di.ViewModelModule
import com.alexandernsalim.moviecatalogue.di.module.NetworkModule
import com.alexandernsalim.moviecatalogue.di.module.SubcomponentsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, SubcomponentsModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun homeComponent(): HomeComponent.Factory
    fun detailMovieComponent(): DetailMovieComponent.Factory
    fun detailTvShowComponent(): DetailTvShowComponent.Factory
}