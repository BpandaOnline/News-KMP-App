package com.coding.meet.newsapp.di

import com.coding.meet.newsapp.data.database.NewsDatabase
import com.coding.meet.newsapp.data.repository.LocalNewsRepository
import com.coding.meet.newsapp.data.repository.OnlineNewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        OnlineNewsRepository(get())
    }
    single {
        LocalNewsRepository(get<NewsDatabase>().newsDao())
    }
}