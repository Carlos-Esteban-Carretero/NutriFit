package com.example.nutrifit.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nutrifit.ui.screens.FormPlanScreen
import com.example.nutrifit.ui.screens.LoginScreen
import com.example.nutrifit.ui.screens.PlanScreen
import com.example.nutrifit.ui.screens.ProfileScreen
import com.example.nutrifit.ui.screens.RecipesDetailsScreen
import com.example.nutrifit.ui.screens.RecipesScreen
import com.example.nutrifit.ui.screens.TipsScreen
import com.example.nutrifit.ui.screens.dayMealPlans
import com.example.nutrifit.ui.screens.previewTips
import com.example.nutrifit.ui.views.RecipeViewModel

@Composable
fun NavigationGraph(navHostController: NavHostController, recipeViewModel: RecipeViewModel) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationScreen.LoginScreen.route
    ) {
        composable(NavigationScreen.FormPlanScreen.route) {
            FormPlanScreen()
        }

        composable(NavigationScreen.PlanScreen.route) {
            PlanScreen(dayMealPlans)
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




