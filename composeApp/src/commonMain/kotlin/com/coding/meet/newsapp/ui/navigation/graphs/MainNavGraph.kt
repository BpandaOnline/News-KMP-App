package com.coding.meet.newsapp.ui.navigation.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coding.meet.newsapp.data.database.NewsDao
import com.coding.meet.newsapp.ui.bookmark.BookMarkScreen
import com.coding.meet.newsapp.ui.headline.HeadlineScreen
import com.coding.meet.newsapp.ui.navigation.Graph
import com.coding.meet.newsapp.ui.navigation.MainRouteScreen
import com.coding.meet.newsapp.ui.search.SearchScreen

@Composable
fun MainNavGraph(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    paddingValues: PaddingValues,
    newsDao: NewsDao
) {
    NavHost(
        modifier = Modifier.fillMaxSize().padding(paddingValues),
        navController = homeNavController,
        route = Graph.MainScreenGraph,
        startDestination = MainRouteScreen.Headline.route
    ){
        composable(route = MainRouteScreen.Headline.route){
            HeadlineScreen(rootNavController)
        }

        composable(route = MainRouteScreen.Search.route){
            SearchScreen(rootNavController)
        }

        composable(route = MainRouteScreen.Bookmark.route){
            BookMarkScreen(rootNavController,newsDao)
        }
    }
}