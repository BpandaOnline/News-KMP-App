package com.coding.meet.newsapp.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.coding.meet.newsapp.data.database.NewsDatabase
import io.ktor.client.request.invoke
import platform.UIKit.*
import platform.Foundation.*
import platform.Foundation.NSHomeDirectory
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerItem
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVFoundation.seekToTime
import platform.CoreMedia.CMTimeMake
import platform.Foundation.NSURL
import androidx.room.Room
import androidx.room.RoomDatabase

actual fun getType(): Type {
    return Type.Mobile
}

actual fun getRandomId(): String {
    return NSUUID().UUIDString()

}

actual fun shareLink(url: String) {
    val currentViewController = UIApplication.sharedApplication().keyWindow?.rootViewController
    val activityViewController = UIActivityViewController(listOf(url), null)
    currentViewController?.presentViewController(
        viewControllerToPresent = activityViewController,
        animated = true,
        completion = null
    )
}

@OptIn(ExperimentalForeignApi::class)
actual fun dataStorePreference(): DataStore<Preferences> {
    return AppSettings.getDataStore(
        producerPath = {
            val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null,
            )
            requireNotNull(documentDirectory).path + "/$dataStoreFileName"
        })
}

actual class VideoPlayer actual constructor() {

    private var player: AVPlayer? = null

    actual fun init(context: Any?) { /* not needed */ }

    actual fun play(videoUrl: String) {
        val url = NSURL(string = videoUrl) ?: return
        player = AVPlayer(playerItem = AVPlayerItem(url = url))
        player?.play()
    }

    actual fun pause() { player?.pause() }

    @OptIn(ExperimentalForeignApi::class)
    actual fun stop() {
        player?.pause()
        player?.seekToTime(CMTimeMake(value = 0, timescale = 1))
    }

    actual fun release() { player = null }

    @Composable
    actual fun VideoView(videoUrl: String,modifier: Modifier) {
        Text("VideoView not implemented on iOS")
    }
}

@Composable
actual fun getPlatformContext(): Any? = null


actual fun getDatabaseBuilder(): RoomDatabase.Builder<NewsDatabase> {
    val dbFilePath = NSHomeDirectory() + "/$DB_NAME"
    return Room.databaseBuilder<NewsDatabase>(
        name = dbFilePath,
    )
}