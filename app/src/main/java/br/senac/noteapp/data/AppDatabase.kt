package br.senac.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class ), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract  fun noteDao(): NoteDao
}