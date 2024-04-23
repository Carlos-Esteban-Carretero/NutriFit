package com.example.nutrifit.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nutrifit.ui.screens.LoginScreen
import com.example.nutrifit.ui.screens.PlanScreen
import com.example.nutrifit.ui.screens.RecipesScreen
import com.example.nutrifit.ui.screens.dayMealPlans


@Composable
fun NavGraph(pepe: NavHostController) {
    NavHost(navController = pepe, startDestination = NavigationScreen.PlanScreen.route) {
        composable(NavigationScreen.PlanScreen.route) {
            PlanScreen()
        }
        composable(NavigationScreen.LoginScreen.route) {
            LoginScreen()
        }
        composable(NavigationScreen.RecipesScreen.route) {


            RecipesScreen(dayMealPlans)
        }
    }
}



