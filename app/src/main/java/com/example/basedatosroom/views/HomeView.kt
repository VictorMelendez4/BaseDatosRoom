package com.example.basedatosroom.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.example.basedatosroom.viewModel.AgendaViewModel
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import com.example.basedatosroom.model.Agenda




//import androidx.room.parser.Section

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController,agendaVM: AgendaViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Agenda") },
                colors =
                    TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
            )
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = Color.White
            )
            {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add"
                )
            }
        }
    )
    {
        ContentHomeView(it,navController,agendaVM)
    }
}
@Composable
fun ContentHomeView(it: PaddingValues,navController: NavController,
                    agendaVM: AgendaViewModel){
    Column(
        modifier = Modifier.padding(it)
    ) {
        val agendaList:List<Agenda> by agendaVM.agendaList.collectAsState()
        LazyColumn {
            items(agendaList){ item->
                val delete= SwipeAction(
                    icon=rememberVectorPainter(Icons.Default.Delete),
                    background=Color.Red,
                    onSwipe={agendaVM.deleteAgenda(item)}
                )
                val delete2=SwipeAction(
                    icon=rememberVectorPainter(Icons.Default.Delete),
                    background = Color.Blue,
                    onSwipe = {agendaVM.deleteAgenda(item)}
                )

                SwipeableActionsBox(
                    startActions = listOf(delete2),
                    endActions =listOf(delete) ,
                    swipeThreshold = 207.dp
                ){

                }
            }

        }
    }
}

