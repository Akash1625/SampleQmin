package com.example.sampleqmin.homedata

data class CustomChannelData (val data: List<CustomItem>)

data class CustomItem(val customName : String? = null,val customDescription : String? = null)