package com.coding.meet.newsapp.ui.setting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.coding.meet.newsapp.ui.setting.component.DeleteBookmarkDialog
import com.coding.meet.newsapp.ui.setting.component.SettingItem
import com.coding.meet.newsapp.ui.setting.component.ThemeSelection
import com.coding.meet.newsapp.utils.Theme
import news_kmp_app.composeapp.generated.resources.Res
import news_kmp_app.composeapp.generated.resources.delete_bookmark
import news_kmp_app.composeapp.generated.resources.ic_delete
import news_kmp_app.composeapp.generated.resources.ic_light_mode
import news_kmp_app.composeapp.generated.resources.setting
import news_kmp_app.composeapp.generated.resources.theme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    rootNavController: NavHostController,
    settingViewModel: SettingViewModel
) {
    val currentTheme by settingViewModel.currentTheme.collectAsState()

    var showThemeSelectionDialog by remember { mutableStateOf(false) }
    var showDeleteBookMarkDialog by remember { mutableStateOf(false) }

    when {
        //settheme
        showThemeSelectionDialog -> {
            ThemeSelection(
                currentTheme = currentTheme ?: Theme.DARK_MODE.name,
                onThemeChange = {
                    settingViewModel.changeThemeMode(it.name)
                    showThemeSelectionDialog = false
                },
                onDismissRequest = {
                    showThemeSelectionDialog = false
                }
            )
        }

        showDeleteBookMarkDialog -> {
            DeleteBookmarkDialog(
                onDismissRequest = {
                    showDeleteBookMarkDialog = false
                },
                onDeleteBookmark = {
                    settingViewModel.deleteAllBookMark()
                    showDeleteBookMarkDialog = false
                }
            )
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(Res.string.setting),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        rootNavController.navigateUp()
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(Res.string.setting)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            item {
                SettingItem(
                    onClick = {
                        showThemeSelectionDialog = true
                    },
                    painter = painterResource(Res.drawable.ic_light_mode),
                    itemName = stringResource(Res.string.theme)
                )
            }

            item {
                SettingItem(
                    onClick = {
                        showDeleteBookMarkDialog = true
                    },
                    painter = painterResource(Res.drawable.ic_delete),
                    itemName = stringResource(Res.string.delete_bookmark),
                    itemColor = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}