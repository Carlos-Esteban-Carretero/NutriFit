package com.example.nutrifit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.nutrifit.ui.components.MainBottomBar
import com.example.nutrifit.ui.navigation.NavGraph
import com.example.nutrifit.ui.theme.NutriFitTheme
import com.example.nutrifit.ui.views.DataViewModel

class MainActivity : ComponentActivity() {
    val dataViewModel: DataViewModel by viewModels()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriFitTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(bottomBar = { MainBottomBar(navController) }
                    ) {
                        NavGraph(navController,dataViewModel)
                    }

                }
            }
        }
    }
}

