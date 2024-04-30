package com.example.nutrifit.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.nutrifit.data.Recipe

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesDetailsScreen(recipe: Recipe, navController: NavController) {
    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver atrás",
                            tint = Color.White,
                            modifier = Modifier.size(60.dp)
                        )
                    }
                },
                title = {
                    Text(text = recipe.name, color = Color.White)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.Blue
                )
            )
        },
        content = {
            RecipesDetailsContent(recipe = recipe)
        }
    )
}

@Composable
fun RecipesDetailsContent(recipe: Recipe) {
    LazyColumn(
        Modifier.background(Color.Black),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 76.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = rememberLazyListState()
    ) {
        item {
            // Tarjeta con la imagen del cóctel
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 3f)
                    .clip(MaterialTheme.shapes.large)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = recipe.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.large)
                )
            }

            // Título de los ingredientes
            Text(
                text = recipe.description,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontSize = 28.sp,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Lista de ingredientes
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = "carbohidratos: ${recipe.carbohydrates}g",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Cyan,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "proteinas: ${recipe.proteins}g",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Green,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "calorias: ${recipe.calories}kcal",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Yellow,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "grasas: ${recipe.fats}g",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Red,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RecipesDetailsScreenPreview() {
    val navController = rememberNavController()
    RecipesDetailsScreen(
        recipe = Recipe(
            name = "Nombre de la receta",
            description = "Descripción de la receta",
            image = "",
            carbohydrates = 100,
            proteins = 100,
            fats = 100,
            calories = 100
        ),
        navController = navController
    )
}
