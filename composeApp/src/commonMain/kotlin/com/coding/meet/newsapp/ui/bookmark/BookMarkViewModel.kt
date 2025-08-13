package com.coding.meet.newsapp.ui.bookmark

import com.coding.meet.newsapp.data.model.Data
import com.coding.meet.newsapp.ui.common.videmodel.KmpViewModel
import com.coding.meet.newsapp.utils.Resource
import com.coding.meet.newsapp.utils.articles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookMarkViewModel : KmpViewModel() {
    private val _newsStateFlow = MutableStateFlow<Resource<List<Data>>>(Resource.Idle)
    val newsStateFlow: StateFlow<Resource<List<Data>>> get() = _newsStateFlow

    init {
        getHeadLine()
    }

    private fun getHeadLine() {
        viewModelScope.launch(Dispatchers.IO) {
            _newsStateFlow.emit(Resource.Loading)
            try {
                val articleList = articles
                _newsStateFlow.emit(Resource.Success(articleList))
            } catch (e: Exception) {
                _newsStateFlow.emit(Resource.Error(e.message ?: "Unknown error"))
            }
        }
    }
}
