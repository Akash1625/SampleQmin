package com.example.sampleqmin.homeadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleqmin.databinding.ItemRestaurantCategoryBinding
import com.example.sampleqmin.homedata.Hotels

class RestaurantCategoryAdapter(
    var restaurant: List<Hotels>,
):
    RecyclerView.Adapter<RestaurantCategoryAdapter.ViewHolder>() {
     class ViewHolder(val view: ItemRestaurantCategoryBinding): RecyclerView.ViewHolder(view.root){
         fun bind(data: Hotels){
             view.tvRestaurantName.text= data.hotelName
             view.tvSpecial.text=data.subHotelName
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =ItemRestaurantCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(restaurant[position])
    }

    override fun getItemCount(): Int {
        return restaurant.size
    }
}
