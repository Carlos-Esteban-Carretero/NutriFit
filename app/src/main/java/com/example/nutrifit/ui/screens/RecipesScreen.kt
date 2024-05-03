package com.example.nutrifit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.nutrifit.data.Recipe
import com.example.nutrifit.ui.navigation.NavigationScreen

@Composable
fun RecipesScreen(recipes: List<Recipe>, navHostController: NavHostController) {
    LazyColumn(
        Modifier.background(Color.Black),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 76.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = rememberLazyListState()
    ) {
        item {
            recipes.forEach { recipe: Recipe ->
                Text(
                    text = recipe.name,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp))
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
                Button(modifier = Modifier.width(230.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue
                    ),
                    onClick = {
                    val route = "${NavigationScreen.RecipesScreen.route}/${recipe.name}"
                    navHostController.navigate(route)
                }
                )
               {
                    Text(
                        text = "+ DETALLES",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )


               }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RecipesScreenPreview() {
    val recipes: List<Recipe> = listOf(Recipe(), Recipe(), Recipe())
    RecipesScreen(recipes, rememberNavController())
}
