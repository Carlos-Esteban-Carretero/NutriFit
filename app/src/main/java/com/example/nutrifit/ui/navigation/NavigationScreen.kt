package com.example.nutrifit.ui.navigation

sealed class NavigationScreen(val route: String) {
    data object PlanScreen : NavigationScreen("Plan")
    data object LoginScreen : NavigationScreen("Login")
    data object RecipesScreen : NavigationScreen("Recipes")
}