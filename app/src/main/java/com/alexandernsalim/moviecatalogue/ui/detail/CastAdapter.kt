package com.alexandernsalim.moviecatalogue.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexandernsalim.moviecatalogue.R
import com.alexandernsalim.moviecatalogue.data.CastEntity
import com.alexandernsalim.moviecatalogue.databinding.ItemCastBinding
import com.bumptech.glide.Glide
import javax.inject.Inject

class CastAdapter @Inject constructor(): RecyclerView.Adapter<CastAdapter.CastViewHolder>() {
    private val casts = ArrayList<CastEntity>()

    fun setCasts(cast: List<CastEntity>?) {
        if (cast == null) return
        this.casts.clear()
        this.casts.addAll(cast)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val itemCastBinding = ItemCastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CastViewHolder(itemCastBinding)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val cast = casts[position]
        holder.bind(cast)
    }

    override fun getItemCount(): Int = casts.size

    inner class CastViewHolder(private val binding: ItemCastBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cast: CastEntity) {
            binding.cast = cast

            with(binding) {
                Glide.with(itemView.context)
                    .load(cast.profilePath)
                    .error(R.drawable.ic_error)
                    .into(ivCast)
            }
        }
    }
}