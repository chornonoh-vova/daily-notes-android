package com.chornonohvova.dailynotes.ui.notes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chornonohvova.dailynotes.model.Note
import com.chornonohvova.dailynotes.ui.theme.DailyNotesTheme
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteItem(note: Note, onClick: () -> Unit, modifier: Modifier = Modifier) {
    OutlinedCard(
        shape = MaterialTheme.shapes.small,
        modifier = modifier,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(all = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = note.date.toString(),
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = note.content,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 3
            )
        }
    }
}

@Preview(widthDp = 200)
@Composable
fun NoteItemPreview() {
    DailyNotesTheme {
        NoteItem(
            note = Note(
                id = 1,
                date = LocalDate.of(2023, 1, 1),
                content = "Daily Note item preview"
            ),
            modifier = Modifier.fillMaxWidth(),
            onClick = { })
    }
}
