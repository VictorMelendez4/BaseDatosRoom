package com.example.basedatosroom.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "agenda")
data class Agenda (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "telefono") val telefono: String?
)
