package com.coding.meet.newsapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.coding.meet.newsapp.data.model.Data

@Database(entities = [Data::class], version = 1, exportSchema = false)
@TypeConverters(SourceTypeConvertor::class)
abstract class NewsDatabase : RoomDatabase(), DB {
    abstract fun newsDao(): NewsDao
    override fun clearAllTables() {
        super.clearAllTables()
    }
}

interface DB {
    fun clearAllTables(): Unit {}
}