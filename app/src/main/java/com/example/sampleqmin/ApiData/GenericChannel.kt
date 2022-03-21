package com.example.sampleqmin.ApiData

import com.example.sampleqmin.GenericItem

data class GenericList(var generic_channels:List<GenericChannel>)

data class GenericChannel(
    var name: String,
    var image_url: String,
    var body_hero_text: String
)
data class GenericChannelResult(
    var statusCode: String,
    var message: String,
    var result: GenericList
)