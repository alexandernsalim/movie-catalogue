package com.alexandernsalim.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alexandernsalim.moviecatalogue.data.CastEntity
import com.alexandernsalim.moviecatalogue.data.MovieEntity
import com.alexandernsalim.moviecatalogue.data.source.MovieRepository
import com.alexandernsalim.moviecatalogue.util.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyCasts = DataDummy.generateDummyCasts()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var castsObserver: Observer<List<CastEntity>>

    @Before
    fun init() {
        viewModel = DetailMovieViewModel(movieRepository)
        viewModel.setMovieId(dummyMovie.id)
    }

    @Test
    fun getMovie() {
        val movieLiveData = MutableLiveData<MovieEntity>()
        movieLiveData.value = dummyMovie

        `when`(movieRepository.getMovieDetail(dummyMovie.id)).thenReturn(movieLiveData)

        val movie = viewModel.getMovie().value as MovieEntity

        verify(movieRepository).getMovieDetail(dummyMovie.id)
        assertNotNull(movie)
        assertEquals(dummyMovie.id, movie.id)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.duration, movie.duration)
        assertEquals(dummyMovie.genres, movie.genres)
        assertEquals(dummyMovie.overview, movie.overview)
        assertEquals(dummyMovie.releaseDate, movie.releaseDate)
        assertEquals(dummyMovie.voteAverage, movie.voteAverage, 0.0)
        assertEquals(dummyMovie.poster, movie.poster)

        viewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getCredits() {
        val castsLiveData = MutableLiveData<List<CastEntity>>()
        castsLiveData.value = dummyCasts

        `when`(movieRepository.getMovieCredits(dummyMovie.id)).thenReturn(castsLiveData)

        val casts = viewModel.getCredits().value as List<CastEntity>

        verify(movieRepository).getMovieCredits(dummyMovie.id)
        assertNotNull(casts)
        assertEquals(dummyCasts.size, casts.size)

        viewModel.getCredits().observeForever(castsObserver)
        verify(castsObserver).onChanged(dummyCasts)
    }
}