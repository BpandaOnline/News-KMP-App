package com.coding.meet.newsapp.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coding.meet.newsapp.ui.MainScreen
import com.coding.meet.newsapp.ui.navigation.Graph
import com.coding.meet.newsapp.ui.navigation.SettingRouteScreen
import com.coding.meet.newsapp.ui.setting.SettingScreen

@Composable
fun RootNavGraph() {
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
            SettingScreen(rootNavController)
        }
    }
}