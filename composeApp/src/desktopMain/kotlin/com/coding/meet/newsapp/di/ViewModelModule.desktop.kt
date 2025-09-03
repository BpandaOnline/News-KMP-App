package com.coding.meet.newsapp.di

import com.coding.meet.newsapp.ui.article_detail.ArticleDetailViewModel
import com.coding.meet.newsapp.ui.bookmark.BookMarkViewModel
import com.coding.meet.newsapp.ui.headline.HeadLineViewModel
import com.coding.meet.newsapp.ui.search.SearchViewModel
import com.coding.meet.newsapp.ui.setting.SettingViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelModule = module {
    singleOf(::HeadLineViewModel)
    singleOf(::SearchViewModel)
    singleOf(::BookMarkViewModel)
    singleOf(::ArticleDetailViewModel)
    singleOf(::SettingViewModel)
}