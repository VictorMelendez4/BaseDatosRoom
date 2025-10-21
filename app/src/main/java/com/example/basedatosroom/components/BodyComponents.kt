package com.example.basedatosroom.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(valueName: String,valuePhone: String ,onValueChange: (String) -> Unit){
    Column() {
        Row() {
            OutlinedTextField(
                value = valueName,
                onValueChange = onValueChange,
                label = { Text("Nombre") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .padding(bottom = 15.dp)
            )
        }
        Row(){
            OutlinedTextField(
                value = valuePhone,
                onValueChange = onValueChange,
                label = { Text("Telefono") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .padding(bottom = 15.dp)
            )
        }
    }
}

@Composable
fun Cards(titulo: String?, onClick:()-> Unit){
    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp).clickable{onClick()}){
        Column(modifier = Modifier.padding(15.dp)){
            if(titulo != null){
                Text()
            }
        }
    }
}