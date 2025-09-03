package com.coding.meet.newsapp.ui.headline

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.coding.meet.newsapp.di.koinViewModel
import com.coding.meet.newsapp.ui.common.ArticleListScreen
import com.coding.meet.newsapp.ui.common.EmptyContent
import com.coding.meet.newsapp.ui.common.ShimmerEffect
import news_kmp_app.composeapp.generated.resources.Res
import news_kmp_app.composeapp.generated.resources.ic_browse
import news_kmp_app.composeapp.generated.resources.ic_network_error
import news_kmp_app.composeapp.generated.resources.no_news
import org.jetbrains.compose.resources.stringResource


@Composable
fun HeadlineScreen(navController: NavController) {

//    val headLineViewModel = rememberViewModel { HeadLineViewModel(OnlineNewsRepository()) }

    val headLineViewModel = koinViewModel<HeadLineViewModel>()

    val uiState by headLineViewModel.newsStateFlow.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }

    uiState.DisplayResult(
        onIdle = { /* Optional placeholder */ },
        onLoading = { ShimmerEffect() },
        onSuccess = { articleList ->
            if (articleList.isEmpty()) {
                EmptyContent(
                    message = stringResource(Res.string.no_news),
                    icon = Res.drawable.ic_browse,
                    onRetryClick = {
                        headLineViewModel.getHeadLine()
                    }
                )
            } else {
                ArticleListScreen(articleList, navController = navController)
            }
        },
        onError = {
            EmptyContent(
                message = it,
                icon = Res.drawable.ic_network_error,
                onRetryClick = {
                    headLineViewModel.getHeadLine()
                }
            )
        }
    )
}