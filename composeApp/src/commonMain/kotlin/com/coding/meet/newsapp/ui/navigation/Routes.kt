package com.coding.meet.newsapp.ui.navigation

object Graph {
    const val RootScreenGraph = "rootScreenGraph"
    const val MainScreenGraph = "mainScreenGraph"
}


sealed class MainRouteScreen(var route: String){

    object Headline : MainRouteScreen("headline")
    object Search : MainRouteScreen("search")
    object Bookmark : MainRouteScreen("bookmark")

}

sealed class SettingRouteScreen(var route: String){

    object Setting : MainRouteScreen("setting")

}