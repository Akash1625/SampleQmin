package com.example.sampleqmin



data class GenericChannelData(val data:List<GenericItem>)

data class GenericItem(val eventName : String? = null,val description : String? = null)