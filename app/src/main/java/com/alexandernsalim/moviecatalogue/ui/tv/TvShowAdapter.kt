package com.alexandernsalim.moviecatalogue.ui.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexandernsalim.moviecatalogue.R
import com.alexandernsalim.moviecatalogue.data.TvShowEntity
import com.alexandernsalim.moviecatalogue.databinding.ItemTvShowBinding
import com.alexandernsalim.moviecatalogue.ui.detail.DetailTvShowActivity
import com.bumptech.glide.Glide
import javax.inject.Inject

class TvShowAdapter @Inject constructor() : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val tvShows = ArrayList<TvShowEntity>()

    fun setTvShows(tvShows: List<TvShowEntity>?) {
        if (tvShows == null) return
        this.tvShows.clear()
        this.tvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemTvShowBinding = ItemTvShowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TvShowViewHolder(itemTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = tvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = tvShows.size

    inner class TvShowViewHolder(private val binding: ItemTvShowBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                cardTvShow.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_ID, tvShow.id)
                    itemView.context.startActivity(intent)
                }
                tvTitle.text = tvShow.title
                Glide.with(itemView.context)
                    .load(tvShow.poster)
                    .error(R.drawable.ic_error)
                    .into(ivTvShow)
            }
        }
    }
}