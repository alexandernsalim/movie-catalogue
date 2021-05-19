package com.alexandernsalim.moviecatalogue.di.component

import com.alexandernsalim.moviecatalogue.ui.detail.DetailMovieActivity
import dagger.Subcomponent

@Subcomponent
interface DetailMovieComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailMovieComponent
    }

    fun inject(detailMovieActivity: DetailMovieActivity)
}