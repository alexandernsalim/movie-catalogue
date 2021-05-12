package com.alexandernsalim.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.alexandernsalim.moviecatalogue.data.SeasonEntity
import com.alexandernsalim.moviecatalogue.data.TvShowEntity
import com.alexandernsalim.moviecatalogue.util.DataDummy

class DetailTvShowViewModel : ViewModel() {
    private var tvShowId: Int = 0

    fun setTvShowId(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShowEntity{
        lateinit var tvShowData: TvShowEntity
        val tvShows = DataDummy.generateDummyTvShows()
        for (tvShow in tvShows) {
            if (tvShow.id == tvShowId) {
                tvShowData = tvShow
                break
            }
        }
        return tvShowData
    }

    fun getSeason(): List<SeasonEntity> = DataDummy.generateDummySeason(tvShowId)
}