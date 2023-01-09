package com.chornonohvova.dailynotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.chornonohvova.dailynotes.ui.DailyNotesApp
import com.chornonohvova.dailynotes.ui.theme.DailyNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DailyNotesMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DailyNotesTheme {
                DailyNotesApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}