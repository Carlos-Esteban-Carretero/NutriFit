package com.example.nutrifit.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// Define los niveles de actividad física como una enumeración o lista de datos
val activityLevels = listOf(
    "Sedentario - Nada o poco ejercicio",
    "Ligero - Ejercicio 2-3 días por semana",
    "Moderado - Ejercicio 4-5 días por semana",
    "Alto - Ejercicio 6-7 días por semana",
    "Atleta Profesional - Ejercicio intenso 6-7 días por semana"
)

@Composable
fun PlanScreen() {
    var selectedActivityLevel by remember { mutableStateOf<String?>(null) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¿Cuál es tu nivel de actividad física?",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
            activityLevels.forEach { level ->
                ActivityLevelItem(
                    level = level,
                    selected = level == selectedActivityLevel,
                    onSelect = { selectedActivityLevel = level }
                )
            }
        }
    }

@Composable
fun ActivityLevelItem(level: String, selected: Boolean, onSelect: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onSelect() },
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 8.dp,
        color = if (selected) Color(0xFF757575) else Color(0xFF616161)
    ) {
        Text(
            text = level,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PreviewPlanScreen() {
    PlanScreen()
}
