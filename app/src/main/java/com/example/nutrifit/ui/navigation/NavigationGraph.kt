package com.example.nutrifit.ui.navigation


import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nutrifit.ui.screens.FormPlan2Screen
import com.example.nutrifit.ui.screens.FormPlanScreen
import com.example.nutrifit.ui.screens.LoginScreen
import com.example.nutrifit.ui.screens.PlanScreen
import com.example.nutrifit.ui.screens.ProfileScreen
import com.example.nutrifit.ui.screens.RecipesDetailsScreen
import com.example.nutrifit.ui.screens.RecipesScreen
import com.example.nutrifit.ui.screens.SplashScreen
import com.example.nutrifit.ui.screens.TipsScreen
import com.example.nutrifit.ui.screens.dayMealPlans
import com.example.nutrifit.ui.screens.previewTips
import com.example.nutrifit.ui.views.PlanViewModel
import com.example.nutrifit.ui.views.RecipeViewModel

@Composable
fun NavigationGraph(navHostController: NavHostController, recipeViewModel: RecipeViewModel, planViewModel: PlanViewModel) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationScreen.SplashScreen.route
    ) {
        composable(NavigationScreen.FormPlanScreen.route) {
            FormPlanScreen(navController = navHostController)
        }
        composable(NavigationScreen.FormPlan2Screen.route) {
            FormPlan2Screen() // Llamada a tu pantalla FormPlan2
        }

        composable(NavigationScreen.PlanScreen.route) {
            Log.d("PlanViewModel", "$planViewModel")
            PlanScreen(dayMealPlans)
        }
        composable(NavigationScreen.SplashScreen.route) {
            SplashScreen(navHostController)
        }

        composable(NavigationScreen.LoginScreen.route) {
            LoginScreen(navHostController)
        }

        composable(NavigationScreen.ProfileScreen.route) {
            ProfileScreen()
        }

        composable(NavigationScreen.RecipesScreen.route) {
            val recipes = recipeViewModel.recipes.value
            RecipesScreen(recipes, navHostController)
        }

        composable("${NavigationScreen.RecipesScreen.route}/{recipeName}") {
            val recipeName = it.arguments?.getString("recipeName")
            val recipe = recipeViewModel.recipes.value.find { it.name == recipeName }

            if (recipe != null) {
                RecipesDetailsScreen(recipe = recipe, navController = navHostController)
            } else {
                navHostController.navigate(NavigationScreen.RecipesScreen.route)
            }
        }

        composable(NavigationScreen.TipsScreen.route) {
            TipsScreen(previewTips)
        }
    }
}




