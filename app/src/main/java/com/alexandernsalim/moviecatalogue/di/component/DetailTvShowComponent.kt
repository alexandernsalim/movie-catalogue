package com.alexandernsalim.moviecatalogue.di.component

import com.alexandernsalim.moviecatalogue.ui.detail.DetailTvShowActivity
import dagger.Subcomponent

@Subcomponent
interface DetailTvShowComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailTvShowComponent
    }

    fun inject(detailTvShowActivity: DetailTvShowActivity)
}