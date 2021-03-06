package com.alexandernsalim.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexandernsalim.moviecatalogue.MovieCatalogueApplication
import com.alexandernsalim.moviecatalogue.R
import com.alexandernsalim.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.alexandernsalim.moviecatalogue.databinding.ContentDetailMovieBinding
import com.alexandernsalim.moviecatalogue.util.TopRightCropTransformation
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import javax.inject.Inject

class DetailMovieActivity : AppCompatActivity() {

    @Inject lateinit var castAdapter: CastAdapter
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<DetailMovieViewModel> { viewModelFactory }

    private lateinit var activityDetailBinding: ActivityDetailMovieBinding
    private lateinit var contentDetailBinding: ContentDetailMovieBinding

    companion object {
        const val EXTRA_ID: String = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MovieCatalogueApplication).applicationComponent.detailMovieComponent()
            .create().inject(this)

        super.onCreate(savedInstanceState)

        activityDetailBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        contentDetailBinding = activityDetailBinding.contentDetail
        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_ID)

            viewModel.setMovieId(movieId)
            populateMovieData()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_share) {
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

    private fun populateMovieData() {
        activityDetailBinding.pbMovieDetail.visibility = View.VISIBLE
        activityDetailBinding.content.visibility = View.GONE

        viewModel.getMovie().observe(this, { movie ->
            activityDetailBinding.pbMovieDetail.visibility = View.GONE
            activityDetailBinding.content.visibility = View.VISIBLE
            contentDetailBinding.movie = movie

            with(activityDetailBinding) {
                Glide.with(this@DetailMovieActivity)
                    .load(movie.poster)
                    .transform(TopRightCropTransformation(this@DetailMovieActivity, 1f, 0f))
                    .error(R.drawable.ic_error)
                    .into(ivBackdrop)
                collapsingToolbar.title = movie.title
            }

            with(contentDetailBinding) {
                Glide.with(this@DetailMovieActivity)
                    .load(movie.poster)
                    .error(R.drawable.ic_error)
                    .into(ivPoster)
                rbUserScore.rating = movie.voteAverage.div(20).toFloat()
                for (genre in movie.genres) {
                    val chip = Chip(this@DetailMovieActivity)
                    chip.text = genre
                    chip.isEnabled = false
                    chip.setTextColor(ResourcesCompat.getColor(resources, R.color.black, null))

                    this.cgGenres.addView(chip)
                }
            }
        })

        viewModel.getCredits().observe(this, { casts ->
            castAdapter.setCasts(casts)
            castAdapter.notifyDataSetChanged()

            with(contentDetailBinding.rvCast) {
                layoutManager = LinearLayoutManager(this@DetailMovieActivity, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                this.adapter = castAdapter
            }
        })
    }
}