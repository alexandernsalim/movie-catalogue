package com.alexandernsalim.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.alexandernsalim.moviecatalogue.data.CastEntity
import com.alexandernsalim.moviecatalogue.data.TvShowEntity

interface TvShowDataSource {

    fun listPopularTvShows(): LiveData<List<TvShowEntity>>

    fun getTvShowDetail(tvId: Int): LiveData<TvShowEntity>

    fun getTvShowCredits(tvId: Int): LiveData<List<CastEntity>>
}