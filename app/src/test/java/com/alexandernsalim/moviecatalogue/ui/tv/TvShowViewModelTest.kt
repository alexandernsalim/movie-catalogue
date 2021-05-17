package com.alexandernsalim.moviecatalogue.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
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
class TvShowViewModelTest {
    private val dummyTvShows = DataDummy.generateDummyTvShows()

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowRepository: TvShowRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowEntity>>

    @Before
    fun init() {
        viewModel = TvShowViewModel(tvShowRepository)
    }

    @Test
    fun getTvShows() {
        val tvShowsLiveData = MutableLiveData<List<TvShowEntity>>()
        tvShowsLiveData.value = dummyTvShows

        `when`(tvShowRepository.listPopularTvShows()).thenReturn(tvShowsLiveData)

        val tvShows = viewModel.getTvShows().value as List<TvShowEntity>

        verify(tvShowRepository).listPopularTvShows()
        assertNotNull(tvShows)
        assertEquals(2, tvShows.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}