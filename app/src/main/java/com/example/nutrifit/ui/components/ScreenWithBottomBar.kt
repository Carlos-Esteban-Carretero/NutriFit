// File: ui/components/ScreenWithBottomBar.kt
package com.example.nutrifit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScreenWithBottomBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
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
            NavigationBarItemData("", Icons.Filled.Add) // Quinto botón vacío
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

data class NavigationBarItemData(val title: String, val icon: ImageVector)

// Puedes usar esta vista previa para ver cómo se verá tu componente en el diseño de Android Studio
@Preview(showBackground = true)
@Composable
fun PreviewScreenWithBottomBar() {
    ScreenWithBottomBar(selectedItem = 2, onItemSelected = {}) { paddingValues ->
        // Aquí va el contenido específico de tu pantalla con relleno aplicado
        Box(Modifier.padding(paddingValues).background(Color.Magenta))
    }
}
