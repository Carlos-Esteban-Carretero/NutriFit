package com.example.nutrifit.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun Load() {
    Box {

        CircularProgressIndicator()
    }
    Column {
        Text(text = "Hola", fontSize = 200.sp)
        Text(text = "que tal")
    }
}
