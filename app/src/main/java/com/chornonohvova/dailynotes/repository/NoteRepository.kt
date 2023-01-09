package com.chornonohvova.dailynotes.repository

import com.chornonohvova.dailynotes.dao.NoteDao
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {
    fun getAll() = noteDao.getAll()

    fun findAll(query: String) = noteDao.findAll(query)
}