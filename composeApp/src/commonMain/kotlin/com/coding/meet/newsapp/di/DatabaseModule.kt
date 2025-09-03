package com.coding.meet.newsapp.di

import com.coding.meet.newsapp.utils.AppPreferences
import com.coding.meet.newsapp.utils.dataStorePreference
import com.coding.meet.newsapp.utils.getDatabaseBuilder
import com.coding.meet.newsapp.utils.getRoomDatabase
import org.koin.dsl.module

val databaseModule = module {
  //database
    single {
        getRoomDatabase(getDatabaseBuilder())
    }

    //datastore
    single {
        AppPreferences(dataStorePreference())
    }
}