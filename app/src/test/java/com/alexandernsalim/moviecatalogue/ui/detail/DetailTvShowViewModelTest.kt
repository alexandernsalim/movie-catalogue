package com.alexandernsalim.moviecatalogue.ui.detail

import com.alexandernsalim.moviecatalogue.util.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val dummySeason = DataDummy.generateDummySeason(dummyTvShow.id)

    @Before
    fun init() {
        viewModel = mock(DetailTvShowViewModel::class.java)
    }

    @Test
    fun getTvShow() {
        `when`(viewModel.getTvShow()).thenReturn(dummyTvShow)
        val tvShow = viewModel.getTvShow()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.id, tvShow.id)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.duration, tvShow.duration)
        assertEquals(dummyTvShow.genres, tvShow.genres)
        assertEquals(dummyTvShow.overview, tvShow.overview)
        assertEquals(dummyTvShow.rate, tvShow.rate)
        assertEquals(dummyTvShow.userScore, tvShow.userScore)
        assertEquals(dummyTvShow.poster, tvShow.poster)
    }

    @Test
    fun getSeason() {
        `when`(viewModel.getSeason()).thenReturn(dummySeason)
        val seasons = viewModel.getSeason()
        assertNotNull(seasons)
        assertEquals(8, seasons.size)
    }
}