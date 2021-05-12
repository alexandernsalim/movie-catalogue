package com.alexandernsalim.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alexandernsalim.moviecatalogue.R
import com.alexandernsalim.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.alexandernsalim.moviecatalogue.databinding.ContentDetailMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var contentDetailBinding: ContentDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel

    companion object {
        const val EXTRA_ID: String = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        contentDetailBinding = activityDetailBinding.contentDetail
        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_ID)
            viewModel.setMovieId(movieId)
            populateMovieData()
        }
    }

    private fun populateMovieData() {
        contentDetailBinding.movie = viewModel.getMovie()
        with(contentDetailBinding) {
            rbUserScore.rating = movie?.userScore?.div(20f) ?: 0f
            Glide.with(this@DetailMovieActivity)
                .load(movie?.poster)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_error)
                .into(ivPoster)
        }
    }
}