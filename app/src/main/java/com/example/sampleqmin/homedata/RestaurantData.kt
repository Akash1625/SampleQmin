package com.example.sampleqmin.homedata

data class RestaurantData(var restaurantName: String, var data: List<Hotels>)

data class Hotels(var hotelName:String,var subHotelName:String )