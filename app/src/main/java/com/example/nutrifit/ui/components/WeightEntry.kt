package com.example.nutrifit.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun WeightEntry(paddingValues: PaddingValues) {
    var currentWeight = remember { mutableStateOf("100.0") }
    var goalWeight = remember { mutableStateOf("90") }
    val weightRange = "58 - 78 kg"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = currentWeight.value,
            onValueChange = { currentWeight.value = it },
            label = { Text("Peso actual") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Peso actual"
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = goalWeight.value,
            onValueChange = { goalWeight.value = it },
            label = { Text("Peso objetivo") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Flag, // Reemplaza con el ícono de bandera
                    contentDescription = "Peso objetivo"
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "(debe ser menor al actual debido a que has seleccionado la opción \"perder peso\")")

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Según la escala del IMC, tu peso normal debería estar entre $weightRange")
    }
}