package com.example.basedatosroom.repositiry



import com.example.basedatosroom.model.Agenda
import com.example.basedatosroom.room.AgendaDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class AgendaRepository @Inject constructor
    (private val agendaDataBaseDao: AgendaDatabaseDao) {
    suspend fun addAgenda(agenda: Agenda) =
        agendaDataBaseDao.Insert(agenda)
    suspend fun updateAgenda(agenda: Agenda) =
        agendaDataBaseDao.Update(agenda)
    suspend fun deleteAgenda(agenda: Agenda) =
        agendaDataBaseDao.Delete(agenda)

    fun getAgenda(): Flow<List<Agenda>> =
        agendaDataBaseDao.getAll().flowOn(Dispatchers.IO).conflate()
    fun getAgendaById(id: String): Flow<List<Agenda>> =
        agendaDataBaseDao.getById(id).flowOn(Dispatchers.IO).conflate()

}