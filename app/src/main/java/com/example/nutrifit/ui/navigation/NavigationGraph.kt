package com.example.nutrifit.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nutrifit.ui.screens.HomeScreen
import com.example.nutrifit.ui.screens.ObjectivesUserScreen



@Composable
fun NavGraph(pepe: NavHostController) {
  NavHost(navController = pepe, startDestination =NavigationScreen.HomeScreen.route) {
    composable(NavigationScreen.HomeScreen.route) {
      HomeScreen()
    }
    composable(NavigationScreen.ObjetivesScreen.route) {
      ObjectivesUserScreen()
    }

  }


}


