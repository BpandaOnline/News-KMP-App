package com.coding.meet.newsapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coding.meet.newsapp.data.model.Data
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Data)

    @Query("Select * from articleTable")
    fun getArticles(): Flow<List<Data>>


}