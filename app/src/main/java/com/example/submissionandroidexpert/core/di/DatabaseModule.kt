package com.example.submissionandroidexpert.core.di

import android.content.Context
import androidx.room.Room
import com.example.submissionandroidexpert.core.data.source.local.room.TlmDao
import com.example.submissionandroidexpert.core.data.source.local.room.TlmDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): TlmDatabase = Room.databaseBuilder(
        context,
        TlmDatabase::class.java, "Games.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: TlmDatabase): TlmDao = database.tlmDao()
}