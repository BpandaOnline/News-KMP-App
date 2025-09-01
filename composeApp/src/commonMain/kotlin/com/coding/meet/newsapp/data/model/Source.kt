package com.coding.meet.newsapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class Source(
    @SerialName("createdate")
    val createdate: String,
    @SerialName("description")
    val description: String
)