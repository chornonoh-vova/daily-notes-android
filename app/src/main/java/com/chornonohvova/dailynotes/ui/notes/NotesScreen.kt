package com.chornonohvova.dailynotes.ui.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chornonohvova.dailynotes.state.NotesUiState

@Composable
internal fun NotesScreen(
    uiState: NotesUiState,
    onNavigateToDetails: (noteId: Int) -> Unit
) {
    if (uiState.isLoading) {
        Text(text = "Loading ...")
    } else {
        LazyColumn {
            items(key = { it.id }, items = uiState.notes) {
                Column(modifier = Modifier.padding(all = 8.dp)) {
                    Text(text = it.date.toString())
                    Text(text = it.content)
                }
            }
        }
    }
}
