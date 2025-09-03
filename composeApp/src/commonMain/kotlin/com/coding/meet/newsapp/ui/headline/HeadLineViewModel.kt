package com.coding.meet.newsapp.ui.headline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coding.meet.newsapp.data.model.Data
import com.coding.meet.newsapp.data.model.NewsResponse
import com.coding.meet.newsapp.data.repository.OnlineNewsRepository
import com.coding.meet.newsapp.utils.Resource
import io.ktor.client.call.body
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HeadLineViewModel(
    private val onlineNewsRepository: OnlineNewsRepository
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
                val httpResponse = onlineNewsRepository.getNews()
                if(httpResponse.status.value in 200..299){
                    val body = httpResponse.body<NewsResponse>()
                    _newsStateFlow.emit(Resource.Success(body.data))
                }else{
                    val body = httpResponse.body<NewsResponse>()
                    _newsStateFlow.emit(Resource.Error(body.toString() ?: "Unknown error"))
                }

            } catch (e: Exception) {
                _newsStateFlow.emit(Resource.Error(e.message ?: "Unknown error"))
            }
        }
    }
}
