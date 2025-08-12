package com.coding.meet.newsapp.ui.common.videmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember

@Composable
inline fun <reified VM : KmpViewModel> rememberViewModel(
    noinline factory: () -> VM
): VM {
    val viewModel = remember { factory() }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.clear() // use public wrapper instead of onCleared()
        }
    }

    return viewModel
}
