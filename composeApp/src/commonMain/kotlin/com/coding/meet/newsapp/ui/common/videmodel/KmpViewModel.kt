package com.coding.meet.newsapp.ui.common.videmodel

import kotlinx.coroutines.CoroutineScope

expect open class KmpViewModel() {
    val viewModelScope: CoroutineScope
    protected open fun onCleared()
    fun clear()
}