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
import news_kmp_app.composeapp.generated.resources.Res
import news_kmp_app.composeapp.generated.resources.ic_browse
import news_kmp_app.composeapp.generated.resources.ic_network_error
import news_kmp_app.composeapp.generated.resources.no_news
import org.jetbrains.compose.resources.stringResource

@Composable
fun BookMarkScreen(navController: NavController) {
    val bookMarkViewModel = rememberViewModel { BookMarkViewModel() }
    val uiState by bookMarkViewModel.newsStateFlow.collectAsState()

    uiState.DisplayResult(
        onIdle = { /* Optional placeholder */ },
        onLoading = { ShimmerEffect() },
        onSuccess = { articleList ->
            if (articleList.isEmpty()) {
                EmptyContent(
                    message = stringResource(Res.string.no_news),
                    icon = Res.drawable.ic_browse,
                    onRetryClick = {

                    }
                )
            } else {
                ArticleListScreen(articleList = articles, navController = navController)
            }
        },
        onError = {
            EmptyContent(
                message = it,
                icon = Res.drawable.ic_network_error,
                onRetryClick = {

                }
            )
        }
    )
}