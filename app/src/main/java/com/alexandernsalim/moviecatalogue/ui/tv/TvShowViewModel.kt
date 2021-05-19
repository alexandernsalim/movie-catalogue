package com.alexandernsalim.moviecatalogue.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alexandernsalim.moviecatalogue.data.TvShowEntity
import com.alexandernsalim.moviecatalogue.data.source.TvShowRepository
import javax.inject.Inject

class TvShowViewModel @Inject constructor(private val tvShowRepository: TvShowRepository) : ViewModel() {
    fun getTvShows() : LiveData<List<TvShowEntity>> = tvShowRepository.listPopularTvShows()
}