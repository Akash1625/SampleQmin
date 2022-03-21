package com.example.sampleqmin.homeadapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleqmin.ApiData.CustomChannel
import com.example.sampleqmin.databinding.ItemCustomChannelBinding
import com.example.sampleqmin.homedata.CustomItem

class CustomChannelAdapter(
    var customChannel: List<CustomChannel>,
) : RecyclerView.Adapter<CustomChannelAdapter.ViewHolder>() {
    inner class ViewHolder(private val view: ItemCustomChannelBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(data: CustomChannel) {
            view.tvChannelName.text = data.name
            view.tvDescription.text = data.channel_description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ItemCustomChannelBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(customChannel[position])
    }

    override fun getItemCount(): Int {
        return customChannel.size
    }

}