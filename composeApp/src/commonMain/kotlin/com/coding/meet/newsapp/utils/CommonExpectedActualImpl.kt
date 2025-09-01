package com.coding.meet.newsapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.coding.meet.newsapp.data.database.NewsDatabase
import kotlinx.atomicfu.locks.SynchronizedObject
import kotlinx.atomicfu.locks.synchronized
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import okio.Path.Companion.toPath

expect fun getType(): Type

expect fun getRandomId(): String

expect fun shareLink(url: String)

expect fun dataStorePreference(): DataStore<Preferences>

object AppSettings {
    private lateinit var dataStore: DataStore<Preferences>

    private val lock = SynchronizedObject()

    fun getDataStore(producerPath: () -> String): DataStore<Preferences> {
        return synchronized(lock) {
            if (::dataStore.isInitialized) {
                dataStore
            } else {
                PreferenceDataStoreFactory.createWithPath(
                    produceFile = { producerPath().toPath() }
                ).also { dataStore = it }
            }
        }
    }
}

expect class VideoPlayer() {

    fun init(context: Any?)
    fun play(videoUrl: String)
    fun pause()
    fun stop()
    fun release()

    @Composable
    fun VideoView(videoUrl: String, modifier: Modifier = Modifier)
}
@Composable
expect fun getPlatformContext(): Any?

expect fun getDatabaseBuilder() : RoomDatabase.Builder<NewsDatabase>

fun getRoomDatabase(
    builder: RoomDatabase.Builder<NewsDatabase>
): NewsDatabase{
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

