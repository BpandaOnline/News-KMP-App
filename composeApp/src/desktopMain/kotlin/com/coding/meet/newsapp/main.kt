package com.coding.meet.newsapp


import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import news_kmp_app.composeapp.generated.resources.Res
import news_kmp_app.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource
import java.awt.Dimension

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProject",
        state = WindowState(
            position = WindowPosition(Alignment.Center)
        ),
        icon = painterResource(Res.drawable.logo)
    ) {
        window.minimumSize = Dimension(640, 480)
        App()
    }
}
