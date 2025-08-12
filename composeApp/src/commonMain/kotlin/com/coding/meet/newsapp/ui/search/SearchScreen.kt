package com.coding.meet.newsapp.ui.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.coding.meet.newsapp.theme.mediumPadding
import com.coding.meet.newsapp.ui.common.ArticleListScreen
import com.coding.meet.newsapp.ui.search.components.SearchBarScreen
import com.coding.meet.newsapp.utils.articles

@Composable
fun SearchScreen() {
    var searchQuery by rememberSaveable(){
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(mediumPadding)
    ) {
        SearchBarScreen(
            text = searchQuery,
            onValueChange = {
                searchQuery = it
            },
            onSearch = {query ->
                if(query.trim().isNotEmpty()){
                    println(query)
                }
            }
        )
        ArticleListScreen(articles)
    }
}