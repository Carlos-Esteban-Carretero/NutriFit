package com.example.nutrifit.ui.screens.plan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// La data class para los ítems de la barra de navegación
data class NavigationBarItemData(val title: String, val icon: ImageVector)

// El composable para la barra de navegación en la parte inferior
@Composable
fun BottomNavigationBar(selectedItem: Int, onItemSelected: (Int) -> Unit) {
    val backgroundColor = Color(0xFF2E7D32) // Fondo verde oscuro para la barra de navegación
    val contentColor = Color.White

    NavigationBar(
        containerColor = backgroundColor,
        contentColor = contentColor
    ) {
        val items = listOf(
            NavigationBarItemData("Plan", Icons.Filled.FitnessCenter),
            NavigationBarItemData("Recetas", Icons.Filled.Book),
            NavigationBarItemData("Progreso", Icons.Filled.Timeline),
            NavigationBarItemData("Home", Icons.Filled.Home),
            NavigationBarItemData("Más", Icons.Filled.Add)
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = selectedItem == index,
                onClick = { onItemSelected(index) }
            )
        }
    }
}

// El composable para la pantalla de entrada de peso
@Composable
fun WeightEntryScreen(paddingValues: PaddingValues) {
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
                    imageVector = Icons.Filled.Home, // Reemplaza con el ícono de balanza
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

// El composable principal que incluye la barra de navegación y el contenido de la pantalla
@Composable
fun ScreenWithBottomBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    var selectedItem by remember { mutableStateOf(0) }
    Scaffold(
        bottomBar = { BottomNavigationBar(selectedItem = selectedItem, onItemSelected = onItemSelected) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFA5D6A7)) // Este es el color verde claro para el fondo
                .padding(innerPadding)
        ) {
            content(innerPadding)
        }
    }
}

// Previsualización del composable principal
@Preview(showBackground = true)
@Composable
fun PreviewScreenWithBottomBar() {
    ScreenWithBottomBar(selectedItem = 2, onItemSelected = {}) { paddingValues ->
        WeightEntryScreen(paddingValues)
    }
}
