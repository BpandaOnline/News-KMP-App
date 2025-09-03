package com.coding.meet.newsapp.di

import com.coding.meet.newsapp.ui.article_detail.ArticleDetailViewModel
import com.coding.meet.newsapp.ui.bookmark.BookMarkViewModel
import com.coding.meet.newsapp.ui.headline.HeadLineViewModel
import com.coding.meet.newsapp.ui.search.SearchViewModel
import com.coding.meet.newsapp.ui.setting.SettingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

actual val viewModelModule = module {
    viewModelOf(::HeadLineViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::BookMarkViewModel)
    viewModelOf(::ArticleDetailViewModel)
    viewModelOf(::SettingViewModel)
}