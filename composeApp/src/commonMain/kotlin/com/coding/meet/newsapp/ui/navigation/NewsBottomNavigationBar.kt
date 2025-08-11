package com.coding.meet.newsapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun NewsBottomNavigationBar(
    bottomNavigationItemList: List<BottomNavigationItem>,
    currentRoute: String?,
    onItemClick : (BottomNavigationItem) -> Unit
){
    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        bottomNavigationItemList.forEach { bottomNavigationItem->
            NavigationBarItem(
                selected = currentRoute == bottomNavigationItem.route,
                onClick = {
                    onItemClick(bottomNavigationItem)
                },
                icon = {
                    Icon(
                        painter = painterResource(bottomNavigationItem.icon),
                        contentDescription = stringResource(bottomNavigationItem.title)
                    )
                },
                label = {
                    Text(
                        text = stringResource(bottomNavigationItem.title),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Medium
                    )
                }
            )
        }
    }
}