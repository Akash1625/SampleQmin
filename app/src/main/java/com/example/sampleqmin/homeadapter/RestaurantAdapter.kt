package com.example.sampleqmin.homeadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleqmin.databinding.ItemRestaurantNearMeBinding
import com.example.sampleqmin.homedata.RestaurantData

class RestaurantAdapter(
    var restaurant: List<RestaurantData>,

) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    class ViewHolder(private val view: ItemRestaurantNearMeBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(data: RestaurantData) {
            view.tvHotelName.text = data.restaurantName
            view.rvRestaurants.adapter= RestaurantCategoryAdapter(data.data)
            view.rvRestaurants.layoutManager=LinearLayoutManager(view.root.context,LinearLayoutManager.VERTICAL,false)
                    if (data.data.size>2 ){
                        view.clBottomArrow.visibility=View.VISIBLE
                    }
                    else{
                        view.clBottomArrow.visibility=View.GONE
                    }
        }
        /*fun expand(data: List<RestaurantData>){
            val isExpanded = BooleanArray(data.size) { false }
         view.clBottomArrow.setOnClickListener {
             if (isExpanded[adapterPosition]){
               view.clBottomArrow.isGone
             }
             else{
                 view.clBottomArrow.isGone
             }
         }
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRestaurantNearMeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(restaurant[position])
    }

    override fun getItemCount(): Int {
        return restaurant.size
    }

}