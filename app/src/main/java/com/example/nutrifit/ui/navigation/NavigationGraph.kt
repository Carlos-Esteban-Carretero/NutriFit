package com.example.nutrifit.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nutrifit.ui.screens.LoginScreen
import com.example.nutrifit.ui.screens.PlanScreen
import com.example.nutrifit.ui.screens.RecipesDetailsScreen
import com.example.nutrifit.ui.screens.RecipesScreen
import com.example.nutrifit.ui.screens.dayMealPlans
import com.example.nutrifit.ui.views.DataViewModel


@Composable
fun NavGraph(navHostController: NavHostController, dataViewModel: DataViewModel) {
    NavHost(navController = navHostController, startDestination = NavigationScreen.PlanScreen.route) {
        composable(NavigationScreen.PlanScreen.route) {
            PlanScreen()
        }
        composable(NavigationScreen.LoginScreen.route) {
            LoginScreen()
        }
        composable(NavigationScreen.RecipesScreen.route) {
            RecipesScreen(dayMealPlans)
        }
        composable(NavigationScreen.TipsScreen.route) {
            val pepe = true
            if (pepe){
                val recipe = dataViewModel.state.value[0]
                RecipesDetailsScreen(recipe)
            }
        }
    }
}



