package com.example.nutrifit.ui.navigation

sealed class NavigationScreen(val route: String) {
    data object FormPlanScreen : NavigationScreen("PlanForm")
    data object PlanScreen : NavigationScreen("Plan")
    data object LoginScreen : NavigationScreen("Login")
    data object SplashScreen : NavigationScreen("SplashScreen")
    data object HomeScreen : NavigationScreen("HomeScreen")
    data object RecipesScreen : NavigationScreen("Recipes")
    data object TipsScreen : NavigationScreen("Tips")
    data object ProfileScreen: NavigationScreen( "Profile")
}