package com.example.sampleqmin.homeadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sampleqmin.ApiData.FestivalChannel
import com.example.sampleqmin.ApiData.GenericChannel
import com.example.sampleqmin.R
import com.example.sampleqmin.databinding.ItemFestivalBinding
import com.example.sampleqmin.homedata.FestivalChannelData
import com.example.sampleqmin.homedata.FestivalItem

class FestivalChannelAdapter(
    var festivalChannel: List<GenericChannel>,
) :
    RecyclerView.Adapter<FestivalChannelAdapter.ViewHolder>() {
    inner class ViewHolder(private val view: ItemFestivalBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(data: GenericChannel) {
            view.tvFestivalName.text = data.name
            Glide.with(view.root.context).load(data.image_url).centerCrop().into(view.ivFestival)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemFestivalBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(festivalChannel[position])
    }

    override fun getItemCount(): Int {
        return festivalChannel.size
    }
}