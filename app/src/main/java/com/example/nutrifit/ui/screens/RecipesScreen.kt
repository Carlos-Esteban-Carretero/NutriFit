package com.example.nutrifit.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Meal(
    val name: String,
    val description: String,
    val calories: Int,
    val protein: Int,
    val fat: Int,
    val carbs: Int
)

data class DayMealPlan(
    val dayOfWeek: String,
    val breakfast: Meal,
    val lunch: Meal,
    val snack: Meal,
    val dinner: Meal
)

@Composable
fun MealPlanScreen(dayMealPlans: List<DayMealPlan>) {
    LazyColumn {
        items(dayMealPlans) { dayMealPlan ->
            DayMealPlanCard(dayMealPlan)
        }
    }
}

@Composable
fun DayMealPlanCard(dayMealPlan: DayMealPlan) {
    Surface(
        modifier = Modifier.padding(8.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = dayMealPlan.dayOfWeek,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            MealCard("Desayuno", dayMealPlan.breakfast)
            MealCard("Comida", dayMealPlan.lunch)
            MealCard("Merienda", dayMealPlan.snack)
            MealCard("Cena", dayMealPlan.dinner)
        }
    }
}

@Composable
fun MealCard(mealType: String, meal: Meal) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        // elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "$mealType: ${meal.name}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = meal.description,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Calorías: ${meal.calories} kcal")
            Text(text = "Proteínas: ${meal.protein}g")
            Text(text = "Grasas: ${meal.fat}g")
            Text(text = "Carbohidratos: ${meal.carbs}g")
        }
    }
}

// Sample data for preview
val sampleDayMealPlans = listOf(
    DayMealPlan(
        dayOfWeek = "Lunes",
        breakfast = Meal(
            name = "Tortilla española",
            description = "Con 2 huevos, 50 g de patata y 30 g de cebolla",
            calories = 250,
            protein = 14,
            fat = 15,
            carbs = 15
        ),
        lunch = Meal(
            name = "Ensalada mixta ",
            description = "con 150 g de pechuga de pollo a la plancha, 30 g de lechuga, 50 g de tomate, 40 g de pepino y 30 g de queso fresco.",
            calories = 300,
            protein = 35,
            fat = 7,
            carbs = 10
            // ... define los datos para el almuerzo
        ),
        snack = Meal(
            name = "Yoghurt natural con almendras",
            description = "Yogurt natural (125 g) con 20 g de almendras",
            calories = 200,
            protein = 12,
            fat = 10,
            carbs = 15
            // ... define los datos para la merienda
        ),
        dinner = Meal(
            name = "Bacalao al horno con brocoli y arroz integral",
            description = "Bacalao al horno (150 g) con 200 g de brócoli al vapor y 50 g de arroz integral",
            calories = 350,
            protein = 32,
            fat = 5,
            carbs = 40
            // ... define los datos para la cena
        )
    )
    // ... define el resto de los días
)

@Composable
@Preview
fun MealPlanScreenPreview() {
    MealPlanScreen(dayMealPlans = sampleDayMealPlans)
}
