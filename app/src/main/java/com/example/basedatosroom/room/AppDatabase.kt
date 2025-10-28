package com.example.basedatosroom.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basedatosroom.model.Agenda

@Database(
    entities = [Agenda::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun agendaDao(): AgendaDatabaseDao
}
