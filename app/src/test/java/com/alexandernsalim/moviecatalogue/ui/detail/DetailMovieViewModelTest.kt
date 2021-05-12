package com.alexandernsalim.moviecatalogue.ui.detail

import com.alexandernsalim.moviecatalogue.util.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]

    @Before
    fun init() {
        viewModel = mock(DetailMovieViewModel::class.java)
    }

    @Test
    fun getMovie() {
        `when`(viewModel.getMovie()).thenReturn(dummyMovie)
        val movie = viewModel.getMovie()
        assertNotNull(movie)
        assertEquals(dummyMovie.id, movie.id)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.duration, movie.duration)
        assertEquals(dummyMovie.genres, movie.genres)
        assertEquals(dummyMovie.overview, movie.overview)
        assertEquals(dummyMovie.rate, movie.rate)
        assertEquals(dummyMovie.releaseDate, movie.releaseDate)
        assertEquals(dummyMovie.userScore, movie.userScore)
        assertEquals(dummyMovie.poster, movie.poster)
    }
}