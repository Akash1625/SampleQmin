package com.example.sampleqmin.ApiData

data class FestivalList(var generic_channels:List<GenericChannel>)

data class FestivalChannel(
    var name:String,
    var image_url: String,
)
data class FestivalChannelResult(
    var statusCode: String,
    var message: String,
    var result: FestivalList
)