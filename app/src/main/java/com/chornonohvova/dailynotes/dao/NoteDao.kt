package com.chornonohvova.dailynotes.dao

import androidx.room.*
import com.chornonohvova.dailynotes.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAll(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes where id = :id")
    suspend fun getOne(id: Int): NoteEntity

    @Query("SELECT * FROM notes WHERE date LIKE :query OR content LIKE :query")
    fun findAll(query: String): Flow<List<NoteEntity>>

    @Insert
    suspend fun insert(note: NoteEntity)

    @Update
    suspend fun update(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)
}