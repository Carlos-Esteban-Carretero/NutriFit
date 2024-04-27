package com.example.nutrifit.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.nutrifit.data.Recipe

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesDetailsScreen(recipe: Recipe) {
    RecipesDetailsContent(recipe = recipe)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = recipe.name)
                },
//                navigationIcon = {
//                    IconButton(onClick = onClose) {
//                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
//                    }
//                }
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
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 76.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = rememberLazyListState()
    ) {
        item {
            // Tarjeta con la imagen del cóctel
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 2f)
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
                text = "Ingredients for ${recipe.description}:",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Lista de ingredientes
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "carbohidratos: " + recipe.carbohydrates + "g",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "proteinas: " + recipe.proteins + "g",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "calorias: " + recipe.calories + "kcal",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "grasas: " + recipe.fats + "g",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
            // Título de las instrucciones
            Text(
                text = "Instructions:",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

    }
}


