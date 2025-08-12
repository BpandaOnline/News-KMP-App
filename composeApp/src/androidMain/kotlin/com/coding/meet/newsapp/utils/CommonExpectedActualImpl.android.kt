package com.coding.meet.newsapp.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import java.util.UUID

actual fun getType(): Type {
    return Type.Mobile
}

actual fun getRandomId(): String {
    return UUID.randomUUID().toString()
}