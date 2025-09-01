package com.coding.meet.newsapp.ui.article_detail

import com.coding.meet.newsapp.data.model.Data
import com.coding.meet.newsapp.data.repository.LocalNewsRepository
import com.coding.meet.newsapp.ui.common.videmodel.KmpViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class ArticleDetailViewModel(
    private val localNewsRepository: LocalNewsRepository
) : KmpViewModel(){

    fun bookmarkArticle(currentArticle: Data){
        viewModelScope.launch(Dispatchers.IO) {
            localNewsRepository.upsertArticle(currentArticle)
        }
    }
}