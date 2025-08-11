package com.coding.meet.newsapp

import androidx.compose.runtime.Composable
import com.coding.meet.newsapp.theme.NewsAppTheme
import com.coding.meet.newsapp.ui.MainScreen
import com.coding.meet.newsapp.ui.navigation.graphs.RootNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    NewsAppTheme(true) {
        RootNavGraph()
    }
}