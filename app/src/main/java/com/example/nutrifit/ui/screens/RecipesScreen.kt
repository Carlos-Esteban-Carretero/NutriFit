package com.example.nutrifit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutrifit.R

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
fun RecipesScreen(dayMealPlans: List<DayMealPlan>) {
    LazyColumn {
        items(dayMealPlans) { dayMealPlan ->
            DayMealPlanCard(dayMealPlan)
        }
    }
}

@Composable
fun DayMealPlanCard(dayMealPlan: DayMealPlan) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Text(
                text = dayMealPlan.dayOfWeek,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )
            MealCard("Desayuno", dayMealPlan.breakfast, R.drawable.ic_desayuno)
            MealCard("Comida", dayMealPlan.lunch, R.drawable.ic_comida)
            MealCard("Merienda", dayMealPlan.snack, R.drawable.ic_meriendas)
            MealCard("Cena", dayMealPlan.dinner, R.drawable.ic_cena)
        }
    }
}

@Composable
fun MealCard(mealType: String, meal: Meal, iconId: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = "$mealType icon",
                modifier = Modifier.size(60.dp),
                tint = Color.Unspecified // Para mantener los colores originales del SVG
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = "$mealType: ${meal.name}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = meal.description,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(Modifier.height(8.dp)) // Espacio adicional antes de los macros
            Text(
                text = "Calorías: ${meal.calories} kcal",
                fontWeight = FontWeight.Bold, // Hace que el texto sea negrita
                color = MaterialTheme.colorScheme.primary // Cambia el color para resaltar
            )
            Spacer(Modifier.height(4.dp)) // Espacio entre las líneas de texto
            Text(
                text = "Proteínas: ${meal.protein}g",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "Grasas: ${meal.fat}g",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "Carbohidratos: ${meal.carbs}g",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(16.dp)) // Espacio adicional antes de la imagen

            // Solo mostrar la imagen para el desayuno
            if (mealType == "Desayuno") {
                Image(
                    painter = painterResource(id = R.drawable.tortilladepatatas),
                    contentDescription = "Imagen de ${meal.name}",
                    modifier = Modifier
                        .fillMaxWidth() // Ocupa el ancho máximo disponible
                        .aspectRatio(4f / 3f) // Mantiene la relación de aspecto
                        .padding(top = 8.dp) // Espacio adicional en la parte superior de la imagen
                )
            }
        }
    }
}



//hola
// Dummy data for the preview
val sampleMeals = DayMealPlan(
    dayOfWeek = "Lunes",
    breakfast = Meal(
        name = "Tortilla española",
        description = "Tortilla española con 2 huevos, 50 g de patata y 30 g de cebolla.",
        calories = 250,
        protein = 14,
        fat = 15,
        carbs = 15

    ),
    lunch = Meal(
        name = "Ensalada mixta",
        description = "Con 150 g de pechuga de pollo a la plancha, lechuga, tomate, pepino y queso fresco",
        calories = 350,
        protein = 30,
        fat = 10,
        carbs = 20
    ),
    snack = Meal(
        name = "Yogur natural con almendras",
        description = "Yogur natural con un puñado de almendras",
        calories = 200,
        protein = 10,
        fat = 15,
        carbs = 5
    ),
    dinner = Meal(
        name = "Bacalao al horno con brócoli",
        description = "Bacalao al horno con brócoli al vapor y arroz integral",
        calories = 300,
        protein = 25,
        fat = 5,
        carbs = 35
    )
)

@Preview(showBackground = true)
@Composable
fun RecipesScreenPreview() {
    RecipesScreen(dayMealPlans = listOf(sampleMeals))
}
