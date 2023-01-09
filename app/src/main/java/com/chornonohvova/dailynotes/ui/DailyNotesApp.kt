package com.chornonohvova.dailynotes.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.chornonohvova.dailynotes.ui.notes.NotesRoute
import com.chornonohvova.dailynotes.ui.notes.notesScreen

@Composable
fun DailyNotesApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NotesRoute,
        modifier = modifier
    ) {
        notesScreen(
            onNavigateToDetails = {
                TODO("Implement navigation to note details")
            }
        )
    }
}