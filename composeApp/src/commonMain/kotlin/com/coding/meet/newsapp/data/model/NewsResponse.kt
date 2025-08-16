package com.coding.meet.newsapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("data")
    val `data`: List<Data>,
    @SerialName("status")
    val status: String
)