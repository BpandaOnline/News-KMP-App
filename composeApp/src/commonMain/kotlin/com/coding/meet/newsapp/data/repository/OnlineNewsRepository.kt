package com.coding.meet.newsapp.data.repository

import com.coding.meet.newsapp.utils.BASE_URL
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class OnlineNewsRepository {

    private val httpClient = HttpClient {
        defaultRequest {
            url(BASE_URL)
            contentType(ContentType.Application.Json)
        }
        install(HttpTimeout){
            requestTimeoutMillis = 60_0000
        }
        install(ContentNegotiation){
            json(
                Json{
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    explicitNulls = false
                }
            )
        }
        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.ALL
            logger = object : Logger{
                override fun log(message: String) {
                    co.touchlab.kermit.Logger.d("KtorClient"){
                        message
                    }
                }

            }
        }
    }

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