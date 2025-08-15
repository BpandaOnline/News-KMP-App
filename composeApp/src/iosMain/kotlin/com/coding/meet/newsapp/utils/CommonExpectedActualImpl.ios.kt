package com.coding.meet.newsapp.utils

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import platform.UIKit.*
import platform.Foundation.*
import platform.Foundation.NSHomeDirectory
import kotlinx.cinterop.ExperimentalForeignApi

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