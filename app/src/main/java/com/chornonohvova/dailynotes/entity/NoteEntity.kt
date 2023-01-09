package com.chornonohvova.dailynotes.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chornonohvova.dailynotes.model.Note
import java.time.LocalDate

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey val id: Int,
    val date: String,
    val content: String
)

fun Note.toEntity() = NoteEntity(
    id = id,
    date = date.toString(),
    content = content,
)

fun NoteEntity.toModel() = Note(
    id = id,
    date = LocalDate.parse(date),
    content = content,
)
