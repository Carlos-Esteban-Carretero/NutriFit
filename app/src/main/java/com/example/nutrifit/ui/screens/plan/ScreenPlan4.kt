package com.example.nutrifit.ui.screens.plan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutrifit.R

@Composable
fun SummaryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA5D6A7)) // Este es el color verde claro para el fondo
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Resumen",
            style = MaterialTheme.typography.headlineMedium.copy(color = Color.White, fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(32.dp))

        SummaryItem(
            icon = painterResource(id = R.drawable.ic_bandera), // Reemplaza con el drawable de bandera
            title = "Peso objetivo",
            value = "90.0 kg"
        )

        SummaryItem(
            icon = painterResource(id = R.drawable.ic_fuego), // Reemplaza con el drawable de fuego
            title = "Calorías para mantener mi peso",
            value = "2,617 kcal"
        )

        SummaryItem(
            icon = painterResource(id = R.drawable.ic_fuego), // Reemplaza con el drawable de fuego
            title = "Calorías para perder grasa",
            value = "1,766 kcal a 2,158 kcal"
        )

        SummaryItem(
            icon = painterResource(id = R.drawable.ic_circle_chart), // Reemplaza con el drawable de gráfico circular
            title = "Macronutrientes",
            value = "Proteínas: 32 %\nCarbs: 38 %\nGrasas: 30 %"
        )

        Spacer(modifier = Modifier.height(150.dp))

        Button(
            onClick = { /* TODO: Agregar acción del botón */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
        ) {
            Text("Crear Plan", color = Color.White)
        }
    }
}

@Composable
fun SummaryItem(icon: Painter, title: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = title,
            modifier = Modifier.size(70.dp),
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(title, style = MaterialTheme.typography.bodyLarge.copy(color = Color.White))
            Text(value, style = MaterialTheme.typography.bodyMedium.copy(color = Color.White))
        }
    }
}

@Composable
fun ScreenWithBottomBar() {
    // Aquí debes insertar la lógica de selección de ítems, por ahora se deja en 0 para indicar la primera pestaña
    var selectedItem by remember { mutableStateOf(0) }
    val onItemSelected: (Int) -> Unit = { index ->
        selectedItem = index // Aquí manejas el cambio de pestaña, actualiza según tu lógica de navegación
    }

    Scaffold(
        bottomBar = { BottomNavigationBar(selectedItem = selectedItem, onItemSelected = onItemSelected) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            SummaryScreen() // Incluye aquí tu pantalla de resumen
        }
    }
}

// Asegúrate de tener tu BottomNavigationBar composable aquí

// Previsualización de la pantalla completa
@Preview(showBackground = true)
@Composable
fun PreviewSummaryScreen() { // Nota que cambiamos el nombre aquí
    ScreenWithBottomBar()
}

