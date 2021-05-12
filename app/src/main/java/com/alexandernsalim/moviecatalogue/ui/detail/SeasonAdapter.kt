package com.alexandernsalim.moviecatalogue.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexandernsalim.moviecatalogue.R
import com.alexandernsalim.moviecatalogue.data.SeasonEntity
import com.alexandernsalim.moviecatalogue.databinding.ItemSeasonBinding

class SeasonAdapter : RecyclerView.Adapter<SeasonAdapter.SeasonViewHolder>() {
    private val seasons = ArrayList<SeasonEntity>()

    fun setSeasons(seasons: List<SeasonEntity>?) {
        if (seasons == null) return
        this.seasons.clear()
        this.seasons.addAll(seasons)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        val itemSeasonBinding = ItemSeasonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeasonViewHolder(itemSeasonBinding)
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        val season = seasons[position]
        holder.bind(season)
    }

    override fun getItemCount(): Int = seasons.size

    inner class SeasonViewHolder(private val binding: ItemSeasonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(season: SeasonEntity) {
            binding.season = season
        }
    }
}