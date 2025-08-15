package com.coding.meet.newsapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.coding.meet.newsapp.theme.NewsAppTheme
import com.coding.meet.newsapp.ui.common.videmodel.rememberViewModel
import com.coding.meet.newsapp.ui.navigation.graphs.RootNavGraph
import com.coding.meet.newsapp.ui.setting.SettingViewModel
import com.coding.meet.newsapp.utils.AppPreferences
import com.coding.meet.newsapp.utils.dataStorePreference
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val appPreferences = remember {
        AppPreferences(dataStorePreference())
    }

    val settingViewModel = rememberViewModel { SettingViewModel(appPreferences) }
    val currentTheme by settingViewModel.currentTheme.collectAsState()

    NewsAppTheme(currentTheme) {
        RootNavGraph(settingViewModel)
    }
}