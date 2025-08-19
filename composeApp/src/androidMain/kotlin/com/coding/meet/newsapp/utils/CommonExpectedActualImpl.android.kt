package com.coding.meet.newsapp.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import java.util.UUID
actual fun getType(): Type {
    return Type.Mobile
}

actual fun getRandomId(): String {
    return UUID.randomUUID().toString()
}

actual fun shareLink(url: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, url)
    }
    val intentChooser = Intent.createChooser(intent, "Share Link")
    activityProvider.invoke().startActivity(intentChooser)

}

private var activityProvider: () -> Activity = {
    throw IllegalArgumentException("Error")
}

fun setActivityProvider(provider: () -> Activity) {
    activityProvider = provider
}

actual fun dataStorePreference(): DataStore<Preferences> {
    return AppSettings.getDataStore(
        producerPath = {
            activityProvider.invoke().filesDir
                .resolve(dataStoreFileName)
                .absolutePath
        }
    )
}


actual class VideoPlayer actual constructor() {

    private var player: ExoPlayer? = null
    private var context: Context? = null

    actual fun init(context: Any?) {
        this.context = context as? Context
    }

    actual fun play(videoUrl: String) {
        val ctx = context ?: return
        player = ExoPlayer.Builder(ctx).build().apply {
            setMediaItem(MediaItem.fromUri(videoUrl))
            prepare()
            playWhenReady = true
        }
    }

    actual fun pause() {
        player?.pause()
    }

    actual fun stop() {
        player?.stop()
    }

    actual fun release() {
        player?.release()
        player = null
    }

    @Composable
    actual fun VideoView(videoUrl: String,modifier: Modifier) {
        val ctx = LocalContext.current
        AndroidView(factory = {
            PlayerView(ctx).apply {
                player = ExoPlayer.Builder(ctx).build().also { exo ->
                    exo.setMediaItem(MediaItem.fromUri(videoUrl))
                    exo.prepare()
                    exo.playWhenReady = true
                    this.player = exo
                }
            }
        }, update = { view ->
            // optional: sync ExoPlayer instance if needed
        })
    }
}

@Composable
actual fun getPlatformContext(): Any? {
    return LocalContext.current
}