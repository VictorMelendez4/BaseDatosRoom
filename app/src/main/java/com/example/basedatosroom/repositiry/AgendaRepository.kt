package com.example.basedatosroom.repositiry

import com.example.basedatosroom.model.Agenda
import com.example.basedatosroom.room.AgendaDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AgendaRepository @Inject constructor(private val agendaDatabaseDao: AgendaDatabaseDao){
    suspend fun addAgenda(agenda: Agenda) = agendaDatabaseDao.Insert(agenda)

    suspend fun updateAgenda(agenda: Agenda) = agendaDatabaseDao.Update(agenda)

    suspend fun deleteAgenda(agenda: Agenda) = agendaDatabaseDao.Delete(agenda)

    fun getAgenda(): Flow<List<Agenda>> = agendaDatabaseDao.getAll().flowOn(Dispatchers.IO).conflate()

    fun getAgendaById(id: String): Flow<List<Agenda>> = agendaDatabaseDao.getById(id).flowOn(Dispatchers.IO).conflate()
}