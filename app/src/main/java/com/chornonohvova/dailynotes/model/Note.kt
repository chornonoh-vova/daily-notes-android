package com.chornonohvova.dailynotes.model

import java.time.LocalDate

/**
 * Note model representation
 */
data class Note(
    val id: Int,
    val date: LocalDate,
    val content: String
)
