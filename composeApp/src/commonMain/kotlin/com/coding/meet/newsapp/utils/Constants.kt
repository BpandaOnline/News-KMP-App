package com.coding.meet.newsapp.utils

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import com.coding.meet.newsapp.BuildKonfig
import com.coding.meet.newsapp.data.model.Data
import com.coding.meet.newsapp.ui.navigation.BottomNavigationItem
import com.coding.meet.newsapp.ui.navigation.MainRouteScreen
import news_kmp_app.composeapp.generated.resources.Res
import news_kmp_app.composeapp.generated.resources.bookmark
import news_kmp_app.composeapp.generated.resources.dark_mode
import news_kmp_app.composeapp.generated.resources.headlines
import news_kmp_app.composeapp.generated.resources.ic_bookmark_outlined
import news_kmp_app.composeapp.generated.resources.ic_headline
import news_kmp_app.composeapp.generated.resources.ic_search
import news_kmp_app.composeapp.generated.resources.light_mode
import news_kmp_app.composeapp.generated.resources.search
import news_kmp_app.composeapp.generated.resources.system_default
import org.jetbrains.compose.resources.StringResource


val apiKey = BuildKonfig.API_KEY

const val dataStoreFileName = "setting.preferences_pb"

const val BASE_URL = "https://bpanda.online/"

const val DB_NAME = "NewsDB"
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
        description = "toijt5oiyiohy",
        image = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
        postid = "post123",
        tags = "nature,travel",
        thumbnail = "https://bpanda.online/bmanify/uploadedFiles/file_688ac018c2037.jpg",
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
        username = "JohnDoe",
        video = null
    )
)

enum class Theme(val title: StringResource){
    SYSTEM_DEFAULT(Res.string.system_default),
    LIGHT_MODE(Res.string.light_mode),
    DARK_MODE(Res.string.dark_mode)
}

val FadeIn = fadeIn(animationSpec = tween(220, delayMillis = 90)) +
        scaleIn(
            initialScale = 0.92f,
            animationSpec = tween(220, delayMillis = 90)
        )

val FadeOut = fadeOut(animationSpec = tween(90))