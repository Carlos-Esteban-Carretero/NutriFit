package com.example.nutrifit.ui.navigation


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
import com.example.nutrifit.ui.screens.TestScreen
import com.example.nutrifit.ui.screens.TipsScreen
import com.example.nutrifit.ui.screens.dayMealPlans
import com.example.nutrifit.ui.screens.previewTips
import com.example.nutrifit.ui.views.DataViewModel

@Composable
fun NavigationGraph(navHostController: NavHostController, dataViewModel: DataViewModel) {
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
            val recipes = dataViewModel.recipes.value
            RecipesScreen(recipes, navHostController)
        }

        composable("${NavigationScreen.RecipesScreen.route}/{recipeName}") {
            val recipeName = it.arguments?.getString("recipeName")
            val recipe = dataViewModel.recipes.value.find { it.name == recipeName }

            if (recipe != null) {
                RecipesDetailsScreen(recipe = recipe, navController = navHostController)
            } else {
                navHostController.navigate(NavigationScreen.RecipesScreen.route)
            }
        }

        composable(NavigationScreen.TipsScreen.route) {
            TipsScreen(previewTips)
        }

        composable(NavigationScreen.TestScreen.route) {
            val plan = dataViewModel.plans.value[1]
//            val day = "monday"
//            val meal = "breakfast"
//            val recipeDetail = runBlocking {
//                dataViewModel.getRecipeDetailsFromPlan(plan, day, meal)
//            }
            TestScreen(plan, dataViewModel)
        }
    }
}




