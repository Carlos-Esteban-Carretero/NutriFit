package com.example.nutrifit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomePageBtnBar() {
    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { TopSearchBar() },
        bottomBar = { BottomNavigationBar(selectedItem, onItemSelected = { selectedItem = it }) },
        floatingActionButton = { AddRecipeButton() },
        floatingActionButtonPosition = FabPosition.End,
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFA5D6A7)) // Este es el color verde claro para el fondo.
        ) {
            // El contenido principal de tu pantalla iría aquí
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSearchBar() {
    TextField(
        value = "",
        onValueChange = { /* Handle text change */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = { Text("Buscar...") },
        trailingIcon = {
            IconButton(onClick = { /* Handle search click */ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar",
                    tint = Color(0xFF4CAF50) // Aquí aplicas el color al ícono directamente
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent, // Sin color de fondo
            focusedIndicatorColor = Color(0xFF4CAF50), // Color del indicador cuando está enfocado
            unfocusedIndicatorColor = Color(0xFF4CAF50) // Color del indicador cuando no está enfocado
            // Omitimos trailingIconColor porque no se usa aquí
        )
    )
}



@Composable
fun BottomNavigationBar(selectedItem: Int, onItemSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color(0xFF2E7D32), // Fondo verde oscuro para la barra de navegación
    ) {
        val items = listOf(
            Icons.Filled.FitnessCenter,
            Icons.Filled.Book,
            Icons.Filled.Timeline,
            Icons.Filled.Home,
            Icons.Filled.Add
        )
        val labels = listOf("Plan", "Recetas", "Progreso", "Home", "")

        items.zip(labels).forEachIndexed { index, pair ->
            val icon = pair.first
            val label = pair.second

            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) },
                selected = selectedItem == index,
                onClick = { onItemSelected(index) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White.copy(alpha = 0.6f)
                )
            )
        }
    }
}

@Composable
fun AddRecipeButton() {
    FloatingActionButton(
        onClick = { /* Aquí manejas la acción de añadir una receta */ },
        containerColor = Color(0xFF4CAF50) // Un color verde que contrastará bien con el fondo claro.
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Añadir receta")
    }
}

@Preview(showBackground = true)
@Composable
fun HomePageBtnBarPreview() {
    HomePageBtnBar()
}
