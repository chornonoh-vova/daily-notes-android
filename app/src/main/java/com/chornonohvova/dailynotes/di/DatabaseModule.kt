package com.chornonohvova.dailynotes.di

import android.content.Context
import androidx.room.Room
import com.chornonohvova.dailynotes.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun providesDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "daily-notes-database"
        ).build()

    @Provides
    fun providesNoteDao(database: AppDatabase) = database.noteDao()
}