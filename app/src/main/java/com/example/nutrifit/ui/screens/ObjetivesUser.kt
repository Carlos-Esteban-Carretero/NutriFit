package com.example.nutrifit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ObjectivesUserScreen() {
    // Valores de ejemplo, estos se actualizarían con la lógica real de tu aplicación
    val ejemploImc = "23.4"
    val descripcionImc = "según la OMS está dentro del rango normal."

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA5D6A7)) // Color de fondo verde
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¿CUÁL ES TU OBJETIVO?",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Botones de objetivos (Perder peso, Ganar peso, Vida saludable)
        ObjectiveButton(
            text = "Perder peso",
            onClick = { /* TODO: Handle perder peso */ }
        )
        ObjectiveButton(
            text = "Ganar peso",
            onClick = { /* TODO: Handle ganar peso */ }
        )
        ObjectiveButton(
            text = "Vida saludable",
            onClick = { /* TODO: Handle vida saludable */ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Su Índice De Masa Corporal es: $ejemploImc",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = " Su IMC $descripcionImc",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun ObjectiveButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Text(text = text, fontWeight = FontWeight.Medium)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewObjectivesUserScreen() {
    ObjectivesUserScreen()
}
