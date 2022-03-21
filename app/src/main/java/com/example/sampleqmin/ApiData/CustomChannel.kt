package com.example.sampleqmin.ApiData

data class CustomList(var custom_channels: List<CustomChannel>)

data class CustomChannel(
    var name: String,
    var image_url: String,
    var header_text: String,
    var body_hero_text: String,
    var channel_description:String
)

data class CustomChannelResult(
    var statusCode: String,
    var message: String,
    var result: CustomList
)