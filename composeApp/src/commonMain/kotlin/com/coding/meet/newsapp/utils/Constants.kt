package com.coding.meet.newsapp.utils

import com.coding.meet.newsapp.data.Data
import com.coding.meet.newsapp.data.NewsResponse
import com.coding.meet.newsapp.ui.MainScreen
import com.coding.meet.newsapp.ui.navigation.BottomNavigationItem
import com.coding.meet.newsapp.ui.navigation.MainRouteScreen
import news_kmp_app.composeapp.generated.resources.Res
import news_kmp_app.composeapp.generated.resources.bookmark
import news_kmp_app.composeapp.generated.resources.headlines
import news_kmp_app.composeapp.generated.resources.ic_bookmark_outlined
import news_kmp_app.composeapp.generated.resources.ic_headline
import news_kmp_app.composeapp.generated.resources.ic_search
import news_kmp_app.composeapp.generated.resources.search
import kotlin.random.Random

enum class Type{
    Mobile,
    Desktop
}

val bottomNavigationItemList = listOf(
    BottomNavigationItem(
        icon = Res.drawable.ic_headline,
        title = Res.string.headlines,
        route = MainRouteScreen.Headline.route
    ),
    BottomNavigationItem(
        icon = Res.drawable.ic_search,
        title = Res.string.search,
        route = MainRouteScreen.Search.route
    ),
    BottomNavigationItem(
        icon = Res.drawable.ic_bookmark_outlined,
        title = Res.string.bookmark,
        route = MainRouteScreen.Bookmark.route
    ),
)

val articles: List<Data> = listOf(
    Data(
        createdate = "2025-08-10",
        description = "Sample description for preview",
        image = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        postid = "post123",
        tags = "nature,travel",
        thumbnail = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        totallikes = 123,
        username = "JohnDoe",
        video = null
    ),
    Data(
        createdate = "2025-08-11",
        description = "Sample description for preview",
        image = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        postid = "post123",
        tags = "nature,travel",
        thumbnail = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        totallikes = 123,
        username = "JohnDoe",
        video = null
    ),
    Data(
        createdate = "2025-08-12",
        description = "Sample description for preview",
        image = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        postid = "post123",
        tags = "nature,travel",
        thumbnail = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        totallikes = 123,
        username = "JohnDoe",
        video = null
    ),
    Data(
        createdate = "2025-08-13",
        description = "Sample description for preview",
        image = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        postid = "post123",
        tags = "nature,travel",
        thumbnail = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        totallikes = 123,
        username = "JohnDoe",
        video = null
    ),
    Data(
        createdate = "2025-08-14",
        description = "Sample description for preview",
        image = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        postid = "post123",
        tags = "nature,travel",
        thumbnail = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        totallikes = 123,
        username = "JohnDoe",
        video = null
    ),
    Data(
        createdate = "2025-08-15",
        description = "Sample description for preview",
        image = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        postid = "post123",
        tags = "nature,travel",
        thumbnail = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        totallikes = 123,
        username = "JohnDoe",
        video = null
    ),
    Data(
        createdate = "2025-08-16",
        description = "Sample description for preview",
        image = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        postid = "post123",
        tags = "nature,travel",
        thumbnail = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        totallikes = 123,
        username = "JohnDoe",
        video = null
    ),
    Data(
        createdate = "2025-08-17",
        description = "Sample description for preview",
        image = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        postid = "post123",
        tags = "nature,travel",
        thumbnail = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        totallikes = 123,
        username = "JohnDoe",
        video = null
    )
)

val newsResponse = NewsResponse(
    articles,
    "success"
)