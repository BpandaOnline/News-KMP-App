package com.coding.meet.newsapp.ui.headline

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.coding.meet.newsapp.data.repository.OnlineNewsRepository
import com.coding.meet.newsapp.ui.common.ArticleListScreen
import com.coding.meet.newsapp.ui.common.EmptyContent
import com.coding.meet.newsapp.ui.common.ShimmerEffect
import com.coding.meet.newsapp.ui.common.videmodel.rememberViewModel
import com.coding.meet.newsapp.utils.articles


@Composable
fun HeadlineScreen(navController: NavController) {

    val headLineViewModel = rememberViewModel { HeadLineViewModel(OnlineNewsRepository()) }
    val uiState by headLineViewModel.newsStateFlow.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }

    uiState.DisplayResult(
        onIdle = { /* Optional placeholder */ },
        onLoading = { ShimmerEffect() },
        onSuccess = { articleList ->
            if (articleList.isEmpty()) {
                EmptyContent("No News")
            } else {
                ArticleListScreen(articleList, navController = navController)
            }
        },
        onError = { errorMsg ->
            EmptyContent(errorMsg)

            // 🔹 Trigger snackbar only once per error
            LaunchedEffect(errorMsg) {
                snackbarHostState.showSnackbar(
                    message = errorMsg,
                    withDismissAction = true // gives an "X" to dismiss
                )
            }
        }
    )
}