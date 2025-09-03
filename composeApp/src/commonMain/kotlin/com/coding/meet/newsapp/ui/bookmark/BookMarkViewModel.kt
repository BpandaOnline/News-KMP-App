package com.coding.meet.newsapp.ui.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coding.meet.newsapp.data.model.Data
import com.coding.meet.newsapp.data.repository.LocalNewsRepository
import com.coding.meet.newsapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class BookMarkViewModel(
    private val localNewsRepository: LocalNewsRepository
) : ViewModel() {
    private val _newsStateFlow = MutableStateFlow<Resource<List<Data>>>(Resource.Loading)
    val newsStateFlow: StateFlow<Resource<List<Data>>> get() = _newsStateFlow

    init {
        getHeadLine()
    }

    fun getHeadLine() {
        viewModelScope.launch(Dispatchers.IO) {
            _newsStateFlow.emit(Resource.Loading)
            try {
                localNewsRepository.getArticles().catch {
                    it.printStackTrace()
                    _newsStateFlow.emit(Resource.Error(it.message ?: "Unknown error"))
                }.collect { articleList ->
                    _newsStateFlow.emit(Resource.Success(articleList))
                }
            } catch (e: Exception) {
                _newsStateFlow.emit(Resource.Error(e.message ?: "Unknown error"))
            }
        }
    }
}
