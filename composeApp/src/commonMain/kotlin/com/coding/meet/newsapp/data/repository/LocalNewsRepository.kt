package com.coding.meet.newsapp.data.repository

import com.coding.meet.newsapp.data.database.NewsDao
import com.coding.meet.newsapp.data.model.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.flowOn

class LocalNewsRepository(
    private val newsDao: NewsDao
) {
    suspend fun upsertArticle(article: Data){
        newsDao.upsert(article)
    }

    suspend fun deleteArticle(article: Data){
        newsDao.delete(article)
    }

    fun deleteAllArticle(){
        newsDao.deleteAllArticle()
    }

    fun getArticles() = newsDao.getArticles().flowOn(Dispatchers.IO)

    suspend fun getArticle(articleId: String) : Data?{
        return newsDao.getArticle(articleId)
    }
}