package com.example.nutrifit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.nutrifit.data.Recipe
import com.example.nutrifit.ui.navigation.NavigationScreen

@Composable
fun RecipesScreen(recipes: List<Recipe>, navHostController: NavHostController) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 76.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = rememberLazyListState()
    ) {
        item {
            recipes.forEach { recipe: Recipe ->
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
                Button(onClick = {
                    val route = "${NavigationScreen.ProfileScreen.route}/${recipe.name}"
                    navHostController.navigate(route)
                }) {}
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun RecipesScreenPreview() {
//    RecipesScreen()
//}
