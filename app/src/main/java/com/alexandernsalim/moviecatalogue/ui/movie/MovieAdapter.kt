package com.alexandernsalim.moviecatalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexandernsalim.moviecatalogue.R
import com.alexandernsalim.moviecatalogue.data.MovieEntity
import com.alexandernsalim.moviecatalogue.databinding.ItemMovieBinding
import com.alexandernsalim.moviecatalogue.ui.detail.DetailMovieActivity
import com.bumptech.glide.Glide
import javax.inject.Inject

class MovieAdapter @Inject constructor() : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val movies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.movies.clear()
        this.movies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                cardMovie.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_ID, movie.id)
                    itemView.context.startActivity(intent)
                }
                tvTitle.text = movie.title
                Glide.with(itemView.context)
                    .load(movie.poster)
                    .error(R.drawable.ic_error)
                    .into(ivMovie)
            }
        }
    }
}