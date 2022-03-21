package com.example.sampleqmin.homeadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sampleqmin.ApiData.GenericChannel
import com.example.sampleqmin.ApiData.GenericChannelResult
import com.example.sampleqmin.GenericItem
import com.example.sampleqmin.databinding.ItemGenericChannelBinding

class GenericChannelAdapter(
    var genericChannel: List<GenericChannel>,
) : RecyclerView.Adapter<GenericChannelAdapter.ViewHolder>() {
    class ViewHolder(private val view: ItemGenericChannelBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(data: GenericChannel) {
            view.tvEventName.text = data.name
            view.tvDescription.text = data.body_hero_text
            Glide.with(view.root.context).load(data.image_url).centerCrop().into(view.ivFood)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ItemGenericChannelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(genericChannel[position])
    }

    override fun getItemCount(): Int {
        return genericChannel.size
    }
}