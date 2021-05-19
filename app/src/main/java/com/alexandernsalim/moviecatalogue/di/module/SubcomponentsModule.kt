package com.alexandernsalim.moviecatalogue.di.module

import com.alexandernsalim.moviecatalogue.di.component.DetailMovieComponent
import com.alexandernsalim.moviecatalogue.di.component.DetailTvShowComponent
import com.alexandernsalim.moviecatalogue.di.component.HomeComponent
import dagger.Module

@Module(subcomponents = [HomeComponent::class, DetailMovieComponent::class, DetailTvShowComponent::class])
class SubcomponentsModule