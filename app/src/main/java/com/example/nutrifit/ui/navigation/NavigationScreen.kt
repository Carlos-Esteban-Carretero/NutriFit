package com.example.nutrifit.ui.navigation

sealed class NavigationScreen(val route: String) {
    object HomeScreen :NavigationScreen ("Home")
    object ObjetivesScreen :NavigationScreen ("Objetives")
}