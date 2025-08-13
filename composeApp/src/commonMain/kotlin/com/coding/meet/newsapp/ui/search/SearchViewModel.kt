package com.coding.meet.newsapp.ui.search

import com.coding.meet.newsapp.data.model.Data
import com.coding.meet.newsapp.ui.common.videmodel.KmpViewModel
import com.coding.meet.newsapp.utils.Resource
import com.coding.meet.newsapp.utils.articles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel : KmpViewModel() {
    private val _newsStateFlow = MutableStateFlow<Resource<List<Data>>>(Resource.Idle)
    val newsStateFlow: StateFlow<Resource<List<Data>>> get() = _newsStateFlow


    fun searchQueryNews(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _newsStateFlow.emit(Resource.Loading)
            try {
                val articleList = articles
//                val articleList = arrayListOf<Data>()
                _newsStateFlow.emit(Resource.Success(articleList))
            } catch (e: Exception) {
                _newsStateFlow.emit(Resource.Error(e.message ?: "Unknown error"))
            }
        }
    }
}
