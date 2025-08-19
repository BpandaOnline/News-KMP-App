package com.coding.meet.newsapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery
import uk.co.caprica.vlcj.player.component.CallbackMediaPlayerComponent
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent
import java.awt.Component
import java.awt.Desktop
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.net.URI
import java.util.Locale
import java.util.UUID
import javax.swing.JButton
import javax.swing.JOptionPane
import javax.swing.JPanel

actual fun getType(): Type {
   return Type.Desktop
}

actual fun getRandomId(): String {
    return UUID.randomUUID().toString()
}


actual fun shareLink(url: String) {
    val clipboard = Toolkit.getDefaultToolkit().systemClipboard
    clipboard.setContents(StringSelection(url), null)
}

actual fun dataStorePreference(): DataStore<Preferences> {
    return AppSettings.getDataStore {
        dataStoreFileName
    }
}

actual class VideoPlayer actual constructor() {

    actual fun init(context: Any?) {
        // Optional: VLC discovery can be done inside VideoPlayerImpl
        NativeDiscovery().discover()

    }

    actual fun play(videoUrl: String) {
        // Empty: handled inside VideoPlayerImpl Composable
    }

    actual fun pause() {
        // Optional: implement if needed
    }

    actual fun stop() {
        // Optional: implement if needed
    }

    actual fun release() {
        // Optional: handled by DisposableEffect in Composable
    }

    @Composable
    actual fun VideoView(videoUrl: String, modifier: Modifier) {
        var vlcFound by remember { mutableStateOf<Boolean?>(null) }

        // Check for VLC only once
        LaunchedEffect(Unit) {
            vlcFound = NativeDiscovery().discover()
        }

        when (vlcFound) {
            false -> showVlcAlert("VLC not installed! Please install VLC.")
            true -> VideoPlayerImpl(url = videoUrl, modifier = modifier)
            null -> {} // still checking
        }
    }
}

@Composable
private fun VideoPlayerImpl(
    url: String,
    modifier: Modifier,
) {
    val mediaPlayerComponent = remember { initializeMediaPlayerComponent() }
    val mediaPlayer = remember { mediaPlayerComponent.mediaPlayer() }

    val factory = remember { { mediaPlayerComponent } }

    LaunchedEffect(url) {
        mediaPlayer.media().play(url)
    }

    DisposableEffect(Unit) {
        onDispose { mediaPlayer.release() }
    }

    SwingPanel(
        factory = factory,
        modifier = modifier
    )
}

private fun initializeMediaPlayerComponent(): Component {
    NativeDiscovery().discover()
    return if (isMacOS()) {
        CallbackMediaPlayerComponent()
    } else {
        EmbeddedMediaPlayerComponent()
    }
}

private fun Component.mediaPlayer() = when (this) {
    is CallbackMediaPlayerComponent -> mediaPlayer()
    is EmbeddedMediaPlayerComponent -> mediaPlayer()
    else -> error("mediaPlayer() can only be called on vlcj player components")
}

private fun isMacOS(): Boolean {
    val os = System.getProperty("os.name", "generic").lowercase(Locale.ENGLISH)
    return "mac" in os || "darwin" in os
}

fun showVlcAlert(message: String) {
    // Custom panel with Download button
    val panel = JPanel()
    val downloadButton = JButton("Download VLC")
    downloadButton.addActionListener {
        try {
            Desktop.getDesktop().browse(URI("https://www.videolan.org/vlc/"))
        } catch (_: Exception) {}
    }
    panel.add(downloadButton)

    // Show message dialog with the panel
    JOptionPane.showMessageDialog(
        null,
        arrayOf(message, panel),
        "VLC Not Found",
        JOptionPane.WARNING_MESSAGE
    )
}

@Composable
actual fun getPlatformContext(): Any? = null