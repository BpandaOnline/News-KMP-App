package com.coding.meet.newsapp.ui.bookmark

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
fun BookMarkScreen(navController: NavController) {
    val bookMarkViewModel = rememberViewModel { BookMarkViewModel() }
    val uiState by bookMarkViewModel.newsStateFlow.collectAsState()

    uiState.DisplayResult(
        onIdle = { /* Optional placeholder */ },
        onLoading = { ShimmerEffect() },
        onSuccess = { articleList ->
            if(articleList.isEmpty()){
                EmptyContent("No News")
            }else {
                ArticleListScreen(articleList = articles, navController = navController)
            }
        },
        onError = { EmptyContent(it) }
    )
}