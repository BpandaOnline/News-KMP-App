package com.coding.meet.newsapp.ui.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.coding.meet.newsapp.data.repository.OnlineNewsRepository
import com.coding.meet.newsapp.theme.mediumPadding
import com.coding.meet.newsapp.ui.common.ArticleListScreen
import com.coding.meet.newsapp.ui.common.EmptyContent
import com.coding.meet.newsapp.ui.common.ShimmerEffect
import com.coding.meet.newsapp.ui.common.videmodel.rememberViewModel
import com.coding.meet.newsapp.ui.search.components.SearchBarScreen
import news_kmp_app.composeapp.generated.resources.Res
import news_kmp_app.composeapp.generated.resources.ic_browse
import news_kmp_app.composeapp.generated.resources.ic_network_error
import news_kmp_app.composeapp.generated.resources.no_news
import news_kmp_app.composeapp.generated.resources.type_to_search
import org.jetbrains.compose.resources.stringResource

@Composable
fun SearchScreen(navController: NavController) {
    var searchQuery by rememberSaveable() {
        mutableStateOf("")
    }

    val searchViewModel = rememberViewModel { SearchViewModel(OnlineNewsRepository()) }
    val uiState by searchViewModel.newsStateFlow.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(mediumPadding)
    ) {
        SearchBarScreen(
            text = searchQuery,
            onValueChange = {
                searchQuery = it
            },
            onSearch = { query ->
                if (query.trim().isNotEmpty()) {
                    searchViewModel.searchQueryNews(query)
                }
            }
        )

        uiState.DisplayResult(
            onIdle = {
                EmptyContent(
                    message = stringResource(Res.string.type_to_search),
                    icon = Res.drawable.ic_browse,
                    isOnRetryBtnVisible = false
                )
            },
            onLoading = { ShimmerEffect() },
            onSuccess = { articleList ->
                if (articleList.isEmpty()) {
                    EmptyContent(
                        message = stringResource(Res.string.no_news),
                        icon = Res.drawable.ic_browse,
                        onRetryClick = {
                            if (searchQuery.trim().isNotEmpty()) {
                                searchViewModel.searchQueryNews(searchQuery)
                            }
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
                        if (searchQuery.trim().isNotEmpty()) {
                            searchViewModel.searchQueryNews(searchQuery)
                        }
                    }
                )
            }
        )
    }
}