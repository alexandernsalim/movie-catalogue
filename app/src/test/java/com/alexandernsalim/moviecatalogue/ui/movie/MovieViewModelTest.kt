package com.alexandernsalim.moviecatalogue.ui.movie

import com.alexandernsalim.moviecatalogue.data.MovieEntity
import com.alexandernsalim.moviecatalogue.util.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val emptyMovies = ArrayList<MovieEntity>()

    @Before
    fun init() {
        viewModel = mock(MovieViewModel::class.java)
    }

    @Test
    fun getMovies() {
        `when`(viewModel.getMovies()).thenReturn(dummyMovies)
        val movies = viewModel.getMovies()
        assertNotNull(movies)
        assertEquals(19, movies.size)
    }

    @Test
    fun getMoviesReturnEmpty() {
        `when`(viewModel.getMovies()).thenReturn(emptyMovies)
        val movies = viewModel.getMovies()
        assertNotNull(movies)
        assertEquals(0, movies.size)
    }
}