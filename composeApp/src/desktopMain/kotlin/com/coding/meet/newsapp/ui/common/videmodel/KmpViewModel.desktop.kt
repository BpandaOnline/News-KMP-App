package com.coding.meet.newsapp.ui.common.videmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

actual open class KmpViewModel {
    private val job = SupervisorJob()
    actual val viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.Main + job)

    protected actual open fun onCleared() {
        job.cancel()
    }

    actual fun clear() {
        onCleared()
    }
}