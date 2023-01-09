package com.chornonohvova.dailynotes.ui.notes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chornonohvova.dailynotes.state.NotesUiState

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun NotesScreen(
    uiState: NotesUiState,
    onNavigateToNoteDetails: (noteId: Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Daily Notes") }
            )
        },
        floatingActionButton = {
            if (!uiState.isLoading) {
                ExtendedFloatingActionButton(
                    onClick = { },
                    icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "Create") },
                    text = { Text(text = "Create") }
                )
            }
        },
        contentWindowInsets = WindowInsets(left = 8.dp, top = 8.dp, right = 8.dp, bottom = 8.dp),
        content = { innerPadding ->
            if (uiState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.fillMaxWidth())
            } else {
                LazyColumn(
                    modifier = Modifier.consumedWindowInsets(innerPadding),
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(key = { it.id }, items = uiState.notes) {
                        NoteItem(
                            note = it,
                            modifier = Modifier.fillMaxWidth(),
                            onClick = { onNavigateToNoteDetails(it.id) }
                        )
                    }
                }
            }
        }
    )
}
