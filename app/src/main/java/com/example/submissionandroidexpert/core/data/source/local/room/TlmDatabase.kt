package com.example.submissionandroidexpert.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.submissionandroidexpert.core.data.source.local.entity.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
abstract class TlmDatabase : RoomDatabase() {
    abstract fun tlmDao(): TlmDao
}