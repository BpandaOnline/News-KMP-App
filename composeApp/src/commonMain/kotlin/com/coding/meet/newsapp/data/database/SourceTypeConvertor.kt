package com.coding.meet.newsapp.data.database


import androidx.room.TypeConverter
import com.coding.meet.newsapp.data.model.Source
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SourceTypeConvertor {
    @TypeConverter
    fun fromSourceToString(value: Source): String{
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun fromStringToSource(value: String): Source{
        return Json.decodeFromString(value)
    }
}