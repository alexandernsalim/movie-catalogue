package com.alexandernsalim.moviecatalogue.ui.tv

import com.alexandernsalim.moviecatalogue.data.TvShowEntity
import com.alexandernsalim.moviecatalogue.util.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    private val dummyTvShows = DataDummy.generateDummyTvShows()
    private val emptyTvShows = ArrayList<TvShowEntity>()

    @Before
    fun init() {
        viewModel = mock(TvShowViewModel::class.java)
    }

    @Test
    fun getTvShows() {
        `when`(viewModel.getTvShows()).thenReturn(dummyTvShows)
        val tvShows = viewModel.getTvShows()
        assertNotNull(tvShows)
        assertEquals(10, tvShows.size)
    }

    @Test
    fun getTvShowsReturnEmpty() {
        `when`(viewModel.getTvShows()).thenReturn(emptyTvShows)
        val tvShows = viewModel.getTvShows()
        assertNotNull(tvShows)
        assertEquals(0, tvShows.size)
    }
}