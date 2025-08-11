package com.coding.meet.newsapp.utils

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