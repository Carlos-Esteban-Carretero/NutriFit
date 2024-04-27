package com.example.nutrifit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val dayOfWeek: String, val breakfast: Meal, val lunch: Meal, val snack: Meal, val dinner: Meal
)

val daysOfWeek = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
val dayMealPlans = daysOfWeek.map { day ->
    val sampleMeals = DayMealPlan(
        dayOfWeek = "Lunes", breakfast = Meal(
            name = "Tortilla española",
            description = "Tortilla española con 2 huevos, 50 g de patata y 30 g de cebolla.",
            calories = 250,
            protein = 14,
            fat = 15,
            carbs = 15
        ), lunch = Meal(
            name = "Ensalada mixta",
            description = "Con 150 g de pechuga de pollo a la plancha, lechuga, tomate, pepino y queso fresco",
            calories = 350,
            protein = 30,
            fat = 10,
            carbs = 20
        ), snack = Meal(
            name = "Yogur natural con almendras",
            description = "Yogur natural con un puñado de almendras",
            calories = 200,
            protein = 10,
            fat = 15,
            carbs = 5
        ), dinner = Meal(
            name = "Bacalao al horno con brócoli",
            description = "Bacalao al horno con brócoli al vapor y arroz integral",
            calories = 300,
            protein = 25,
            fat = 5,
            carbs = 35
        )
    )
    DayMealPlan(
        day, sampleMeals.breakfast, sampleMeals.lunch, sampleMeals.snack, sampleMeals.dinner
    )
}

@Composable
fun PlanScreen(dayMealPlans: List<DayMealPlan>) {
    LazyColumn(
        modifier = Modifier.background(Color.Black) // Sets the background color to black for the LazyColumn
    ) {
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
            .background(Color.Black)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            // Fondo amarillo con esquinas redondeadas para el día de la semana
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFEB3B), RoundedCornerShape(10.dp)) // Fondo amarillo
                    .padding(vertical = 10.dp)
            ) {
                Text(
                    text = dayMealPlan.dayOfWeek,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 70.sp,  fontWeight = FontWeight.ExtraBold, color = Color.Black
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            MealCard("Desayuno", dayMealPlan.breakfast, R.drawable.ic_desayuno)
            MealCard("Comida", dayMealPlan.lunch, R.drawable.ic_comida)
            MealCard("Merienda", dayMealPlan.snack, R.drawable.ic_meriendas)
            MealCard("Cena", dayMealPlan.dinner, R.drawable.ic_cena)
        }
    }
}

@Composable
fun MealCard(mealType: String, meal: Meal, iconId: Int) {
    val textColor = Color.Yellow // Un color que destaque sobre fondo negro
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = "$mealType icon",
                    modifier = Modifier.size(80.dp),
                    tint = Color.Unspecified // Para mantener los colores originales del SVG
                )
                Column {
                    Box (Modifier.size(200.dp,40.dp).background(Color (0xC0FF5722), RoundedCornerShape(10.dp))){
                        Text(
                            textAlign = TextAlign.Center,
                            text = "$mealType:",
                            // El tipo de comida, como "Desayuno:"
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 30.sp,
                               fontWeight = FontWeight.ExtraBold,
                                color = textColor // Usa el color personalizado para el texto
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(60.dp)
                                .wrapContentHeight(align = Alignment.CenterVertically)// Añade espacio debajo del título
                        )

                    }

                    Text(
                        textAlign = TextAlign.Center,
                        text = "${meal.name}",
                        // El tipo de comida, como "Desayuno:"
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 26.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.primary,
                            textDecoration = TextDecoration.Underline
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(60.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically)// Añade espacio debajo del título
                    )
                }
            }

            Text(
                text = meal.description,
                fontSize = 20.sp,
               fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White // Asegúrate de que el texto sea visible en el fondo negro

            )
            Spacer(Modifier.height(8.dp)) // Espacio adicional antes de los macros
            Text(
                text = "Calorías: ${meal.calories} kcal",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold, // Hace que el texto sea negrita
                color = Color.Yellow
            )
            Spacer(Modifier.height(4.dp)) // Espacio entre las líneas de texto
            Text(
                text = "Proteínas: ${meal.protein}g",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "Grasas: ${meal.fat}g",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "Carbohidratos: ${meal.carbs}g",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Cyan,
            )
            Spacer(Modifier.height(16.dp)) // Espacio adicional antes de la imagen
            Image(
                painter = painterResource(id = R.drawable.tortilladepatatas),
                contentDescription = "Imagen de ${meal.name}",
                modifier = Modifier
                    .fillMaxWidth() // Ocupa el ancho máximo disponible
                    .aspectRatio(4f / 4f) // Mantiene la relación de aspecto
                    .padding(top = 8.dp) // Espacio adicional en la parte superior de la imagen
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PlanScreenPreview() {
    PlanScreen(dayMealPlans = dayMealPlans)
}
