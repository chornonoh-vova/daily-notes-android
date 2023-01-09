package com.chornonohvova.dailynotes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chornonohvova.dailynotes.entity.toModel
import com.chornonohvova.dailynotes.repository.NoteRepository
import com.chornonohvova.dailynotes.state.NotesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {
    val uiState =
        noteRepository.getAll().map { notes ->
            NotesUiState(
                isLoading = false,
                notes = notes.map { note ->
                    note.toModel()
                }
            )
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = NotesUiState()
            )
}