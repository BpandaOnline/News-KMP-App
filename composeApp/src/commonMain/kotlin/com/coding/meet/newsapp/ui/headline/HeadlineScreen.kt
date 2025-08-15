package com.coding.meet.newsapp.ui.headline

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.coding.meet.newsapp.ui.common.ArticleListScreen
import com.coding.meet.newsapp.ui.common.EmptyContent
import com.coding.meet.newsapp.ui.common.ShimmerEffect
import com.coding.meet.newsapp.ui.common.videmodel.rememberViewModel
import com.coding.meet.newsapp.utils.articles


@Composable
fun HeadlineScreen(navController: NavController) {
    val headLineViewModel = rememberViewModel { HeadLineViewModel() }
    val uiState by headLineViewModel.newsStateFlow.collectAsState()

    uiState.DisplayResult(
        onIdle = { /* Optional placeholder */ },
        onLoading = { ShimmerEffect() },
        onSuccess = { articleList ->
            if(articleList.isEmpty()){
                EmptyContent("No News")
            }else {
                ArticleListScreen(articles, navController = navController)
            }
        },
        onError = { EmptyContent(it) }
    )
}