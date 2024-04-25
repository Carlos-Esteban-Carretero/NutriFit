package com.example.nutrifit.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutrifit.R
import com.example.nutrifit.ui.theme.NutriFitTheme

@Composable
fun FormPlan2Screen(
    imc: Double?,
    age: String,
    gender: String
) {
    val activityLevels = listOf(
        "Sedentario - Nada o poco ejercicio",
        "Ligero - Ejercicio 2-3 días por semana",
        "Moderado - Ejercicio 4-5 días por semana",
        "Alto - Ejercicio 6-7 días por semana",
        "Atleta Profesional - Ejercicio intenso 6-7 días por semana"
    )

    var selectedActivityLevel by remember { mutableStateOf(activityLevels.first()) }
    var selectedDiet by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Text(
//            text = stringResource(id = R.string.activity_level_question),
//            color = Color.White,
//            style = MaterialTheme.typography.bodyLarge,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )

        DropdownMenu(
            items = activityLevels,
            selectedItem = selectedActivityLevel,
            onItemSelected = { selectedActivityLevel = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.select_diet),
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Radio button options for diet selection
        val diets = listOf(
            "Dieta baja en calorías",
            "Dieta alta en calorías",
            "Dieta de mantenimiento"
        )

        diets.forEach { diet ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedDiet == diet,
                    onClick = { selectedDiet = diet },
                    colors = RadioButtonDefaults.colors(unselectedColor = Color.Gray)
                )
                Text(
                    text = diet,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun DropdownMenu(
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopStart)
    ) {
        OutlinedButton(
            onClick = { expanded = true },
            border = BorderStroke(1.dp, Color.Gray),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
        ) {
            Text(
                text = selectedItem,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Left
            )
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null // Decorative icon doesn't need description
            )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEach { label ->
//                DropdownMenuItem(
//                    onClick = {
//                        expanded = false
//                        onItemSelected(label)
//                    }
//                ) {
                    Text(text = label, color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormPlan2ScreenPreview() {
    NutriFitTheme {
        FormPlan2Screen(
            imc = 25.0,
            age = "25",
            gender = "Hombre"
        )
    }
}
