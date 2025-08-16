package com.coding.meet.newsapp.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.coding.meet.newsapp.data.model.Data
import com.coding.meet.newsapp.theme.xLargePadding
import com.coding.meet.newsapp.ui.navigation.NewsRouteScreen
import com.coding.meet.newsapp.utils.Type
import com.coding.meet.newsapp.utils.articles
import com.coding.meet.newsapp.utils.getRandomId
import com.coding.meet.newsapp.utils.getType
import kotlinx.serialization.json.Json


@Composable
fun ArticleListScreen(
    articleList: List<Data>,
    navController: NavController
) {

    val isDesktop = remember {
        getType() == Type.Desktop
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(if (isDesktop) 3 else 1),
        verticalArrangement = Arrangement.spacedBy(xLargePadding),
        horizontalArrangement = Arrangement.spacedBy(xLargePadding),
        contentPadding = PaddingValues(xLargePadding)
    ) {
        items(articleList, key = {
            it.createdate + getRandomId()
        }) { article ->
            ArticleItem(article = article, onClick = {
                val articleStr = Json.encodeToString(article)
                navController.currentBackStackEntry?.savedStateHandle?.apply {
                    set("article",articleStr)
                }
                navController.navigate(NewsRouteScreen.NewsDetail.route)
            })
        }
    }
}