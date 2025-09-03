package com.coding.meet.newsapp.data.repository

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse

class OnlineNewsRepository(
    private val httpClient: HttpClient
) {

    suspend fun getNews() : HttpResponse{
        return httpClient.get{
            url("bmanify/postAllSearch.php")
        }
    }

    suspend fun searchNews(query: String) : HttpResponse{
        return httpClient.get{
            url("bmanify/postSearch.php")
            parameter("query",query)
        }
    }
}