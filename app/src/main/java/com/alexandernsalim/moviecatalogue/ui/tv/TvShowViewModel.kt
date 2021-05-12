package com.alexandernsalim.moviecatalogue.ui.tv

import androidx.lifecycle.ViewModel
import com.alexandernsalim.moviecatalogue.data.TvShowEntity
import com.alexandernsalim.moviecatalogue.util.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShows() : List<TvShowEntity> = DataDummy.generateDummyTvShows()
}