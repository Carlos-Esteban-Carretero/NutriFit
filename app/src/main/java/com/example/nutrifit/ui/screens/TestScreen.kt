package com.example.nutrifit.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.nutrifit.data.Plan
import com.example.nutrifit.ui.views.DataViewModel
import kotlinx.coroutines.runBlocking


@Composable
fun TestScreen(plan: Plan, dataViewModel: DataViewModel) {
    Column {
        plan.schedule.forEach { (day, meal) ->
            Column {
                // Fondo amarillo con esquinas redondeadas para el día de la semana
                Text(text = day)
                meal.forEach { (meal, recipe) ->
                    Column {
                        val recipeDetail = runBlocking {
                            dataViewModel.getRecipeDetailsFromPlan(plan, day, meal)
                        }

                        if (recipeDetail?.name != null) {
                            Text(text = "$meal : ${recipeDetail.name}")
                        }
                    }
                }
            }
        }
    }
}