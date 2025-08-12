package com.coding.meet.newsapp.data.model

data class Data(
    val createdate: String,
    val description: String,
    val image: String,
    val postid: String,
    val tags: String,
    val thumbnail: String,
    val totallikes: Int,
    val username: String,
    val video: Any?
)