package com.coding.meet.newsapp.ui.article_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coding.meet.newsapp.data.model.Data
import com.coding.meet.newsapp.data.repository.LocalNewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class ArticleDetailViewModel(
    private val localNewsRepository: LocalNewsRepository
) : ViewModel(){

    var isBookmarked by mutableStateOf(false)

    fun isArticleBookmark(currentArticle: Data){
        viewModelScope.launch(Dispatchers.IO) {
            localNewsRepository.getArticle(currentArticle.postid)?.let {
                isBookmarked = true
            }
        }
    }
    fun bookmarkArticle(currentArticle: Data){
        viewModelScope.launch(Dispatchers.IO) {
            if(!isBookmarked){
                localNewsRepository.upsertArticle(currentArticle)
            }else{
                localNewsRepository.deleteArticle(currentArticle)
            }
            isBookmarked = !isBookmarked
        }
    }
}