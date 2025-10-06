package com.example.basedatosroom.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.basedatosroom.model.Agenda
//import com.example.roomdb.model.Agenda

@Dao
interface AgendaDatabaseDao {
    //CRUD
    @Query("Select * from agenda")
    fun getAll(): List<Agenda>

    @Query("Select * from agenda where id = :id")
    fun getById(id: Int): List<Agenda>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Insert(agenda: Agenda)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun Update(agenda: Agenda)

    @Delete
    fun Delete(agenda: Agenda)






}