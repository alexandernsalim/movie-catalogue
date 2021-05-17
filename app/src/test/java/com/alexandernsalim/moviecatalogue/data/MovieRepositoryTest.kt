package com.alexandernsalim.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alexandernsalim.moviecatalogue.data.source.remote.RemoteDataSource
import com.alexandernsalim.moviecatalogue.data.source.remote.response.CreditsResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.MovieDetailResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.PopularMoviesResponse
import com.alexandernsalim.moviecatalogue.util.DataDummy
import com.alexandernsalim.moviecatalogue.util.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryTest {

    private lateinit var movieRepository: FakeMovieRepository
    private val dummyPopularMoviesResponse = DataDummy.generatePopularMoviesResponse()
    private val dummyMovieDetailResponse = DataDummy.generateMovieDetailResponse()
    private val dummyMovieCredits = DataDummy.generateCreditsResponse()
    private val movieId = dummyMovieDetailResponse.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @Mock
    private lateinit var popularMoviesCall: Call<PopularMoviesResponse>

    @Mock
    private lateinit var movieDetailCall: Call<MovieDetailResponse>

    @Mock
    private lateinit var movieCreditsCall: Call<CreditsResponse>

    @Before
    fun init() {
        movieRepository = FakeMovieRepository(remoteDataSource)
    }

    @Test
    fun listPopularMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as Callback<PopularMoviesResponse>)
                .onResponse(popularMoviesCall, Response.success(dummyPopularMoviesResponse))
            null
        }.`when`(remoteDataSource).getPopularMovies(any())

        val movies = LiveDataTestUtil.getValue(movieRepository.listPopularMovies())

        verify(remoteDataSource).getPopularMovies(any())
        assertNotNull(movies)
        assertEquals(dummyPopularMoviesResponse.results.size, movies.size)
    }

    @Test
    fun getMovieDetail() {
        doAnswer { invocation ->
            (invocation.arguments[1] as Callback<MovieDetailResponse>)
                .onResponse(movieDetailCall, Response.success(dummyMovieDetailResponse))
            null
        }.`when`(remoteDataSource).getMovieDetail(eq(movieId), any())

        val movie = LiveDataTestUtil.getValue(movieRepository.getMovieDetail(movieId))

        verify(remoteDataSource).getMovieDetail(eq(movieId), any())
        assertNotNull(movie)
        assertEquals(dummyMovieDetailResponse.id, movie.id)
        assertEquals(dummyMovieDetailResponse.title, movie.title)
        assertEquals(dummyMovieDetailResponse.overview, movie.overview)
    }

    @Test
    fun getMovieCredits() {
        doAnswer { invocation ->
            (invocation.arguments[1] as Callback<CreditsResponse>)
                .onResponse(movieCreditsCall, Response.success(dummyMovieCredits))
            null
        }.`when`(remoteDataSource).getMovieCredits(eq(movieId), any())

        val casts = LiveDataTestUtil.getValue(movieRepository.getMovieCredits(movieId))

        verify(remoteDataSource).getMovieCredits(eq(movieId), any())
        assertNotNull(casts)
        assertEquals(dummyMovieCredits.cast.size, casts.size)
    }
}