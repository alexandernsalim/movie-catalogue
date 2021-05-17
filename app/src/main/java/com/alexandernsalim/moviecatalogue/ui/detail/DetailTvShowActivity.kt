package com.alexandernsalim.moviecatalogue.ui.detail

import com.alexandernsalim.moviecatalogue.util.TopRightCropTransformation
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexandernsalim.moviecatalogue.R
import com.alexandernsalim.moviecatalogue.data.SeasonEntity
import com.alexandernsalim.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.alexandernsalim.moviecatalogue.databinding.ContentDetailTvShowBinding
import com.alexandernsalim.moviecatalogue.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip

class DetailTvShowActivity : AppCompatActivity() {
    private lateinit var activityDetailBinding: ActivityDetailTvShowBinding
    private lateinit var contentDetailBinding: ContentDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel

    companion object {
        const val EXTRA_ID: String = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        contentDetailBinding = activityDetailBinding.contentDetail
        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModelFactory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getInt(EXTRA_ID)

            viewModel.setTvShowId(tvShowId)
            populateTvShowData()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId

        if (itemId == R.id.action_share) {
            ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Share this movie")
                .setText("Hey, let's watch this together")
                .startChooser()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun populateTvShowData() {
        activityDetailBinding.pbTvShowDetail.visibility = View.VISIBLE
        activityDetailBinding.content.visibility = View.GONE

        viewModel.getTvShow().observe(this, { tvShow ->
            activityDetailBinding.pbTvShowDetail.visibility = View.GONE
            activityDetailBinding.content.visibility = View.VISIBLE
            contentDetailBinding.tvShow = tvShow

            with(activityDetailBinding) {
                Glide.with(this@DetailTvShowActivity)
                    .load(tvShow.poster)
                    .transform(TopRightCropTransformation(this@DetailTvShowActivity, 1f, 0f))
                    .error(R.drawable.ic_error)
                    .into(ivBackdrop)
                collapsingToolbar.title = tvShow.title
            }

            with(contentDetailBinding) {
                rbUserScore.rating = tvShow.userScore.div(20).toFloat()
                Glide.with(this@DetailTvShowActivity)
                    .load(tvShow.poster)
                    .error(R.drawable.ic_error)
                    .into(ivPoster)
                for (genre in tvShow.genres) {
                    val chip = Chip(this@DetailTvShowActivity)
                    chip.text = genre
                    chip.isEnabled = false
                    chip.setTextColor(ResourcesCompat.getColor(resources, R.color.black, null))

                    this.cgGenres.addView(chip)
                }
            }

            populateSeason(tvShow.seasons)
        })

        viewModel.getCredits().observe(this, { casts ->
            val adapter = CastAdapter()
            adapter.setCasts(casts)
            adapter.notifyDataSetChanged()

            with(contentDetailBinding.rvCast) {
                layoutManager = LinearLayoutManager(this@DetailTvShowActivity, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        })
    }

    private fun populateSeason(seasons: List<SeasonEntity>?) {
        val adapter = SeasonAdapter()

        adapter.setSeasons(seasons)
        adapter.notifyDataSetChanged()
        with(contentDetailBinding.rvSeason) {
            layoutManager = LinearLayoutManager(this@DetailTvShowActivity)
            setHasFixedSize(true)
            this.adapter = adapter
        }
    }
}