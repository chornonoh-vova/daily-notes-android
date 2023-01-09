package com.chornonohvova.dailynotes.state

import com.chornonohvova.dailynotes.model.Note

data class NotesUiState(
    val isLoading: Boolean = true,
    val notes: List<Note> = listOf()
)