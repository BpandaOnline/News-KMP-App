package com.coding.meet.newsapp.ui.common.videmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope as androidScope
import kotlinx.coroutines.CoroutineScope

actual open class KmpViewModel : ViewModel() {
    actual val viewModelScope: CoroutineScope
        get() = androidScope

    protected actual override fun onCleared() {
        super.onCleared()
    }

    actual fun clear() {
        onCleared() // safe to call
    }
}