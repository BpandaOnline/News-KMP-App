package com.coding.meet.newsapp.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coding.meet.newsapp.data.database.NewsDao
import com.coding.meet.newsapp.data.model.Data
import com.coding.meet.newsapp.ui.MainScreen
import com.coding.meet.newsapp.ui.article_detail.ArticleDetailScreen
import com.coding.meet.newsapp.ui.navigation.Graph
import com.coding.meet.newsapp.ui.navigation.NewsRouteScreen
import com.coding.meet.newsapp.ui.navigation.SettingRouteScreen
import com.coding.meet.newsapp.ui.setting.SettingScreen
import com.coding.meet.newsapp.ui.setting.SettingViewModel
import kotlinx.serialization.json.Json

@Composable
fun RootNavGraph(
    settingViewModel: SettingViewModel
) {
    val rootNavController = rememberNavController()
    NavHost(
        navController = rootNavController,
        route = Graph.RootScreenGraph,
        startDestination = Graph.MainScreenGraph
    ){
        composable(route = Graph.MainScreenGraph){
            MainScreen(rootNavController)
        }

        composable(route = SettingRouteScreen.Setting.route){
            SettingScreen(rootNavController,settingViewModel)
        }

        composable(route = NewsRouteScreen.NewsDetail.route){
            rootNavController.previousBackStackEntry?.savedStateHandle?.get<String>("article")?.let {
                val article : Data = Json.decodeFromString(it)
                ArticleDetailScreen(rootNavController, article)
            }
        }
    }
}