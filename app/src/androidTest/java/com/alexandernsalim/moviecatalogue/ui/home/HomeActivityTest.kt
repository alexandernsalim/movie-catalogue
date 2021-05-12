package com.alexandernsalim.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alexandernsalim.moviecatalogue.R
import com.alexandernsalim.moviecatalogue.util.DataDummy
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShows = DataDummy.generateDummyTvShows()
    private val dummySeasons = DataDummy.generateDummySeason(dummyTvShows[0].id)

    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.tv_release_date)).check(matches(withText(dummyMovies[0].releaseDate)))
        onView(withId(R.id.tv_rate)).check(matches(withText(dummyMovies[0].rate)))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovies[0].overview)))
        onView(withId(R.id.tv_genres)).check(matches(withText(dummyMovies[0].genres)))
        onView(withId(R.id.tv_duration)).check(matches(withText(dummyMovies[0].duration)))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun loadTvShowDetail() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShows[0].title)))
        onView(withId(R.id.tv_rate)).check(matches(withText(dummyTvShows[0].rate)))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyTvShows[0].overview)))
        onView(withId(R.id.tv_genres)).check(matches(withText(dummyTvShows[0].genres)))
        onView(withId(R.id.tv_duration)).check(matches(withText(dummyTvShows[0].duration)))
        onView(withId(R.id.rv_season)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_season)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummySeasons.size))
    }
}