package com.alexandernsalim.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alexandernsalim.moviecatalogue.data.MovieEntity
import com.alexandernsalim.moviecatalogue.data.source.MovieRepository
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
class MovieViewModelTest {
    private val dummyMovies = DataDummy.generateDummyMovies()

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun init() {
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val moviesLiveData = MutableLiveData<List<MovieEntity>>()
        moviesLiveData.value = dummyMovies

        `when`(movieRepository.listPopularMovies()).thenReturn(moviesLiveData)

        val movies = viewModel.getMovies().value as List<MovieEntity>

        verify(movieRepository).listPopularMovies()
        assertNotNull(movies)
        assertEquals(2, movies.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}