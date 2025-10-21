package com.example.basedatosroom.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun MainButtons(icon: ImageVector, tipo:Boolean,onClick: () -> Unit){
    OutlinedButton(
        onClick = { /*TODO*/ },
        enabled = true
    ) {
        if(tipo)
            Text(text = "Guardar")
        else
            Text(text="Actualizar")

    }
}

@Composable
fun FloatButton(onClick: () -> Unit){
    FloatingActionButton(
        onClick=onClick,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White

    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add"
        )
    }
}