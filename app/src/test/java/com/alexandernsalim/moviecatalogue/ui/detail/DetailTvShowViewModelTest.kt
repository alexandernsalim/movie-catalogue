package com.alexandernsalim.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alexandernsalim.moviecatalogue.data.CastEntity
import com.alexandernsalim.moviecatalogue.data.TvShowEntity
import com.alexandernsalim.moviecatalogue.data.source.TvShowRepository
import com.alexandernsalim.moviecatalogue.util.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val dummyCasts = DataDummy.generateDummyCasts()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowRepository: TvShowRepository

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Mock
    private lateinit var castsObserver: Observer<List<CastEntity>>

    @Before
    fun init() {
        viewModel = DetailTvShowViewModel(tvShowRepository)
        viewModel.setTvShowId(dummyTvShow.id)
    }

    @Test
    fun getTvShow() {
        val tvShowLiveData = MutableLiveData<TvShowEntity>()
        tvShowLiveData.value = dummyTvShow

        `when`(tvShowRepository.getTvShowDetail(dummyTvShow.id)).thenReturn(tvShowLiveData)

        val tvShow = viewModel.getTvShow().value as TvShowEntity

        verify(tvShowRepository).getTvShowDetail(dummyTvShow.id)
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.id, tvShow.id)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.duration, tvShow.duration)
        assertEquals(dummyTvShow.genres, tvShow.genres)
        assertEquals(dummyTvShow.overview, tvShow.overview)
        assertEquals(dummyTvShow.rate, tvShow.rate)
        assertEquals(dummyTvShow.userScore, tvShow.userScore, 0.0)
        assertEquals(dummyTvShow.poster, tvShow.poster)
        assertEquals(dummyTvShow.seasons, tvShow.seasons)

        tvShowLiveData.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }

    @Test
    fun getCredits() {
        val tvShowLiveData = MutableLiveData<List<CastEntity>>()
        tvShowLiveData.value = dummyCasts

        `when`(tvShowRepository.getTvShowCredits(dummyTvShow.id)).thenReturn(tvShowLiveData)

        val casts = viewModel.getCredits().value as List<CastEntity>

        verify(tvShowRepository).getTvShowCredits(dummyTvShow.id)
        assertNotNull(casts)
        assertEquals(dummyCasts.size, casts.size)

        viewModel.getCredits().observeForever(castsObserver)
        verify(castsObserver).onChanged(dummyCasts)
    }
}