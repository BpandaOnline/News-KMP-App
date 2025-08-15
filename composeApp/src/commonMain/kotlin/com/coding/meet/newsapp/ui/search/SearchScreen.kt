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
import com.coding.meet.newsapp.theme.mediumPadding
import com.coding.meet.newsapp.ui.common.ArticleListScreen
import com.coding.meet.newsapp.ui.common.EmptyContent
import com.coding.meet.newsapp.ui.common.ShimmerEffect
import com.coding.meet.newsapp.ui.common.videmodel.rememberViewModel
import com.coding.meet.newsapp.ui.search.components.SearchBarScreen
import com.coding.meet.newsapp.utils.articles

@Composable
fun SearchScreen(navController: NavController) {
    var searchQuery by rememberSaveable() {
        mutableStateOf("")
    }

    val searchViewModel = rememberViewModel { SearchViewModel() }
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
                    println(query)
                    searchViewModel.searchQueryNews(query)
                }
            }
        )

        uiState.DisplayResult(
            onIdle = {
                EmptyContent("Type to Search")
            },
            onLoading = { ShimmerEffect() },
            onSuccess = { articleList ->
                if (articleList.isEmpty()) {
                    EmptyContent("No News")
                } else {
                    ArticleListScreen(articles, navController = navController)
                }
            },
            onError = { EmptyContent(it) }
        )
    }
}