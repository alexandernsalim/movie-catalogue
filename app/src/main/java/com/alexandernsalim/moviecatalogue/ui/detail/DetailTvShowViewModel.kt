package com.alexandernsalim.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alexandernsalim.moviecatalogue.data.CastEntity
import com.alexandernsalim.moviecatalogue.data.TvShowEntity
import com.alexandernsalim.moviecatalogue.data.source.TvShowRepository

class DetailTvShowViewModel(private val tvShowRepository: TvShowRepository) : ViewModel() {
    private var tvShowId: Int = 0

    fun setTvShowId(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): LiveData<TvShowEntity> = tvShowRepository.getTvShowDetail(tvShowId)

    fun getCredits(): LiveData<List<CastEntity>> = tvShowRepository.getTvShowCredits(tvShowId)
}