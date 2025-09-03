package com.coding.meet.newsapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.coding.meet.newsapp.di.koinViewModel
import com.coding.meet.newsapp.theme.NewsAppTheme
import com.coding.meet.newsapp.ui.navigation.graphs.RootNavGraph
import com.coding.meet.newsapp.ui.setting.SettingViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val settingViewModel = koinViewModel<SettingViewModel>()
    val currentTheme by settingViewModel.currentTheme.collectAsState()

    NewsAppTheme(currentTheme) {
        RootNavGraph(settingViewModel)
    }
}