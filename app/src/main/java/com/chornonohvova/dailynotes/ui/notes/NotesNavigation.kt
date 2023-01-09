package com.chornonohvova.dailynotes.ui.notes

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chornonohvova.dailynotes.viewmodel.NotesViewModel

const val NotesRoute = "notes"

@OptIn(ExperimentalLifecycleComposeApi::class)
fun NavGraphBuilder.notesScreen(
    onNavigateToDetails: (noteId: Int) -> Unit
) {
    composable(NotesRoute) {
        val notesViewModel = hiltViewModel<NotesViewModel>()
        val notesUiState = notesViewModel.uiState.collectAsStateWithLifecycle()

        NotesScreen(
            uiState = notesUiState.value,
            onNavigateToDetails = onNavigateToDetails
        )
    }
}