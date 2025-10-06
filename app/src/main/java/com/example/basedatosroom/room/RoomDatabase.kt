package com.example.basedatosroom.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdb.model.Agenda

@Database(entities = [Agenda::class], version = 1,
    exportSchema = false)
abstract class RoomDatabase: RoomDatabase() {
    abstract fun agendaDao(): AgendaDatabaseDao
}