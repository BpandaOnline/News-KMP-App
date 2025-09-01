package com.coding.meet.newsapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.coding.meet.newsapp.data.database.NewsDao
import com.coding.meet.newsapp.ui.navigation.NewsBottomNavigationBar
import com.coding.meet.newsapp.ui.navigation.SettingRouteScreen
import com.coding.meet.newsapp.ui.navigation.graphs.MainNavGraph
import com.coding.meet.newsapp.utils.bottomNavigationItemList
import news_kmp_app.composeapp.generated.resources.Res
import news_kmp_app.composeapp.generated.resources.setting
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    rootNavController: NavHostController,
    newsDao: NewsDao
) {

    val homeNavController = rememberNavController()

    val navBackStackEntry by homeNavController.currentBackStackEntryAsState()


    var previousRoute by rememberSaveable {
        mutableStateOf(navBackStackEntry?.destination?.route)
    }

    val currentRoute by remember(navBackStackEntry) {
        derivedStateOf { (navBackStackEntry?.destination?.route) }
    }

    val toBarTitle by remember(currentRoute) {
        derivedStateOf {
            if (currentRoute != null) {
                bottomNavigationItemList[bottomNavigationItemList.indexOfFirst {
                    it.route == currentRoute
                }].title
            } else {
                bottomNavigationItemList[0].title
            }
        }
    }

    DisposableEffect(Unit){
        onDispose {
            previousRoute = currentRoute
        }
    }

    LaunchedEffect(Unit){
        if(previousRoute != null){
            homeNavController.navigate(previousRoute!!) {
                homeNavController.graph.startDestinationRoute?.let { startDestinationRoute ->
                    popUpTo(startDestinationRoute) {
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true
            }
        }else{

        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(toBarTitle),
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                actions = {
                    IconButton(onClick = {
                        rootNavController.navigate(SettingRouteScreen.Setting.route)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = stringResource(
                                Res.string.setting
                            )
                        )
                    }
                }
            )
        }, bottomBar = {
            NewsBottomNavigationBar(
                bottomNavigationItemList = bottomNavigationItemList,
                currentRoute = currentRoute,
                onItemClick = { currentBottomNavigationItem ->
                    homeNavController.navigate(currentBottomNavigationItem.route) {
                        homeNavController.graph.startDestinationRoute?.let { startDestinationRoute ->
                            popUpTo(startDestinationRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->
        MainNavGraph(rootNavController, homeNavController, innerPadding,newsDao)
    }
}