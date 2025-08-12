package com.coding.meet.newsapp.data.model

data class NewsResponse(
    val `data`: List<Data>,
    val status: String
)