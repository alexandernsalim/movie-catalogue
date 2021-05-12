package com.alexandernsalim.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexandernsalim.moviecatalogue.R
import com.alexandernsalim.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.alexandernsalim.moviecatalogue.databinding.ContentDetailTvShowBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailTvShowActivity : AppCompatActivity() {
    private lateinit var contentDetailBinding: ContentDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel

    companion object {
        const val EXTRA_ID: String = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        contentDetailBinding = activityDetailBinding.contentDetail
        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getInt(EXTRA_ID)
            viewModel.setTvShowId(tvShowId)
            populateTvShowData()
        }
    }

    private fun populateTvShowData() {
        contentDetailBinding.tvShow = viewModel.getTvShow()
        with(contentDetailBinding) {
            rbUserScore.rating = tvShow?.userScore?.div(20f) ?: 0f
            Glide.with(this@DetailTvShowActivity)
                .load(tvShow?.poster)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_error)
                .into(ivPoster)
            populateSeason()
        }
    }

    private fun populateSeason() {
        val seasons = viewModel.getSeason()
        val adapter = SeasonAdapter()
        adapter.setSeasons(seasons)
        with(contentDetailBinding.rvSeason) {
            layoutManager = LinearLayoutManager(this@DetailTvShowActivity)
            setHasFixedSize(true)
            this.adapter = adapter
        }
    }
}