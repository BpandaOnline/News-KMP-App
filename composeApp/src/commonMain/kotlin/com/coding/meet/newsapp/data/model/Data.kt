package com.coding.meet.newsapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("createdate")
    val createdate: String,
    @SerialName("description")
    val description: String,
    @SerialName("image")
    val image: String?,
    @SerialName("postid")
    val postid: String,
    @SerialName("tags")
    val tags: String,
    @SerialName("thumbnail")
    val thumbnail: String,
    @SerialName("username")
    val username: String?,
    @SerialName("video")
    val video: String?
)