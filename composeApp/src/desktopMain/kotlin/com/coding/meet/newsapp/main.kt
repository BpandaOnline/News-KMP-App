package com.coding.meet.newsapp


import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import java.awt.Dimension

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProject",
        state = WindowState(
            position = WindowPosition(Alignment.Center)
        )
    ) {
        window.minimumSize = Dimension(1000, 760)
        App()
    }
}
