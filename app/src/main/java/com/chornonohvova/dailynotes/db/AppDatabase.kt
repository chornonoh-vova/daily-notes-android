package com.chornonohvova.dailynotes.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chornonohvova.dailynotes.dao.NoteDao
import com.chornonohvova.dailynotes.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}