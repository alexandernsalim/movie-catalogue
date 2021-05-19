package com.alexandernsalim.moviecatalogue.di.component

import com.alexandernsalim.moviecatalogue.ui.movie.MovieFragment
import com.alexandernsalim.moviecatalogue.ui.tv.TvShowFragment
import dagger.Subcomponent

@Subcomponent
interface HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    fun inject(movieFragment: MovieFragment)
    fun inject(tvShowFragment: TvShowFragment)
}