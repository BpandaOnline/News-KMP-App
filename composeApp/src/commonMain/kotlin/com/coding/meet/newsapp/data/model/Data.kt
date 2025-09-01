package com.coding.meet.newsapp.data.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "articleTable")
data class Data(
    @SerialName("createdate")
    val createdate: String,
    @SerialName("description")
    val description: String,
    @SerialName("image")
    val image: String?,
    @SerialName("postid")
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("articleId")
    val postid: String,
    @SerialName("tags")
    val tags: String,
    @SerialName("thumbnail")
    val thumbnail: String,
    @SerialName("username")
    val username: String?,
    @SerialName("video")
    val video: String?
)