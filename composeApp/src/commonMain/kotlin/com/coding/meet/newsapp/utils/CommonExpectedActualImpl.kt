package com.coding.meet.newsapp.utils

import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.atomicfu.locks.SynchronizedObject
import kotlinx.atomicfu.locks.synchronized
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
