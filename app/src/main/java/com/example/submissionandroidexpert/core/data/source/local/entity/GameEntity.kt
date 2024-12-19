package com.example.submissionandroidexpert.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey
    val key: String,

    @ColumnInfo("thumb")
    val thumb: String,

    @ColumnInfo("author")
    val author: String,

    @ColumnInfo("tag")
    val tag: String,

    @ColumnInfo("time")
    val time: String,

    @ColumnInfo("title")
    val title: String,
    
    @ColumnInfo("desc")
    val desc: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)