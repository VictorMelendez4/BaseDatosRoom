package com.example.basedatosroom.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.basedatosroom.components.MainButtons
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.navigation.NavController
import com.example.basedatosroom.components.MainScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddView(navController:NavController){
    Scaffold(
        topBar={
            CenterAlignedTopAppBar(
                title = { Text("Añadir Registro") },
                colors= TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary

                ),
                navigationIcon = {
                    MainButtons(icon = Icons.Default.ArrowBack,true){
                        navController.popBackStack()
                    }
                }
            )
        }
    ){
        ContentAddView(it)
    }
}

@Composable
fun ContentAddView(it: PaddingValues){
    MainScreen("",""
        ,{})

}