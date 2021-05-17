package com.alexandernsalim.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alexandernsalim.moviecatalogue.data.source.remote.RemoteDataSource
import com.alexandernsalim.moviecatalogue.data.source.remote.response.CreditsResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.PopularTvShowResponse
import com.alexandernsalim.moviecatalogue.data.source.remote.response.TvShowDetailResponse
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
class TvShowRepositoryTest {

    private lateinit var tvShowRepository: FakeTvShowRepository
    private val dummyPopularTvShowsResponse = DataDummy.generatePopularTvShowsResponse()
    private val dummyTvShowDetailResponse = DataDummy.generateTvShowDetailResponse()
    private val dummyTvShowCreditsResponse = DataDummy.generateCreditsResponse()
    private val tvShowId = dummyTvShowDetailResponse.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @Mock
    private lateinit var popularTvShowsCall: Call<PopularTvShowResponse>

    @Mock
    private lateinit var tvShowDetailCall: Call<TvShowDetailResponse>

    @Mock
    private lateinit var tvShowCreditsCall: Call<CreditsResponse>

    @Before
    fun init() {
        tvShowRepository = FakeTvShowRepository(remoteDataSource)
    }

    @Test
    fun listPopularTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as Callback<PopularTvShowResponse>)
                .onResponse(popularTvShowsCall, Response.success(dummyPopularTvShowsResponse))
            null
        }.`when`(remoteDataSource).getPopularTvShows(any())

        val movies = LiveDataTestUtil.getValue(tvShowRepository.listPopularTvShows())

        verify(remoteDataSource).getPopularTvShows(any())
        assertNotNull(movies)
        assertEquals(dummyPopularTvShowsResponse.results.size, movies.size)
    }

    @Test
    fun getTvShowDetail() {
        doAnswer { invocation ->
            (invocation.arguments[1] as Callback<TvShowDetailResponse>)
                .onResponse(tvShowDetailCall, Response.success(dummyTvShowDetailResponse))
            null
        }.`when`(remoteDataSource).getTvShowDetail(eq(tvShowId), any())

        val tvShow = LiveDataTestUtil.getValue(tvShowRepository.getTvShowDetail(tvShowId))

        verify(remoteDataSource).getTvShowDetail(eq(tvShowId), any())
        assertNotNull(tvShow)
        assertEquals(dummyTvShowDetailResponse.id, tvShow.id)
        assertEquals(dummyTvShowDetailResponse.name, tvShow.title)
        assertEquals(dummyTvShowDetailResponse.overview, tvShow.overview)
    }

    @Test
    fun getTvShowCredits() {
        doAnswer { invocation ->
            (invocation.arguments[1] as Callback<CreditsResponse>)
                .onResponse(tvShowCreditsCall, Response.success(dummyTvShowCreditsResponse))
        }.`when`(remoteDataSource).getTvShowsCredits(eq(tvShowId), any())

        val casts = LiveDataTestUtil.getValue(tvShowRepository.getTvShowCredits(tvShowId))

        verify(remoteDataSource).getTvShowsCredits(eq(tvShowId), any())
        assertNotNull(casts)
        assertEquals(dummyTvShowCreditsResponse.cast.size, casts.size)
    }
}