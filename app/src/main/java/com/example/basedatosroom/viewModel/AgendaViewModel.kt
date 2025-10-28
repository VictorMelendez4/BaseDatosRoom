package com.example.basedatosroom.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basedatosroom.model.Agenda
import com.example.basedatosroom.repositiry.AgendaRepository

import kotlinx.coroutines.flow.MutableStateFlow

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgendaViewModel @Inject constructor(private val repository: AgendaRepository): ViewModel() {
    private val _agendaList = MutableStateFlow<List<Agenda>>(emptyList())
    val agendaList=_agendaList.asStateFlow()

    init{
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAgenda().collect{item->
                if(item.isNullOrEmpty()){
                    _agendaList.value=emptyList()
                }
                else
                {
                    _agendaList.value=item
                }

            }
        }
    }

    fun addAgenda(agenda: Agenda)=
        viewModelScope.launch{ repository.addAgenda(agenda)}
    fun updateAgenda(agenda: Agenda)=
        viewModelScope.launch{ repository.updateAgenda(agenda)}
    fun deleteAgenda(agenda: Agenda)=
        viewModelScope.launch{ repository.deleteAgenda(agenda)}
}