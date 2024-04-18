package com.example.nutrifit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BMICalculatorScreen() {
    var gender by remember { mutableStateOf("Hombre") }
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    val bmi by remember { mutableStateOf("Calculando...") }
    val bmiCategory by remember { mutableStateOf("Calculando...") }
    val healthyWeightRange by remember { mutableStateOf("Calculando...") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA5D6A7)) // Un tono de verde claro, cambia el valor del color según tu preferencia
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Calculadora IMC", style = MaterialTheme.typography.headlineMedium)

            GenderSelection(gender) { selectedGender ->
                gender = selectedGender
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Edad") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Altura (cm)") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Peso (kg)") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Resultados del BMI
            Text("Índice De Masa Corporal: $bmi kg/m²")
            Text("Categoría: $bmiCategory")
            Text("Rango de Peso Saludable: $healthyWeightRange")

            Spacer(modifier = Modifier.height(24.dp))

            // Botón de cálculo
            Button(
                onClick = { calculateBMI(age, height, weight, bmi, bmiCategory, healthyWeightRange) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calcular")
            }
        }
    }
}

// Asumiendo que la función calculateBMI necesita más parámetros, la puedes ajustar según tus necesidades.
fun calculateBMI(age: String, height: String, weight: String, bmi: String, bmiCategory: String, healthyWeightRange: String) {
    // Coloca aquí tu lógica para calcular el BMI
}

@Composable
fun GenderSelection(selectedGender: String, onGenderSelected: (String) -> Unit) {
    Row(modifier = Modifier.padding(16.dp)) {
        GenderButton(gender = "Hombre", selectedGender = selectedGender, onGenderSelected = onGenderSelected)
        Spacer(modifier = Modifier.width(8.dp))
        GenderButton(gender = "Mujer", selectedGender = selectedGender, onGenderSelected = onGenderSelected)
    }
}

@Composable
fun GenderButton(gender: String, selectedGender: String, onGenderSelected: (String) -> Unit) {
    Button(
        onClick = { onGenderSelected(gender) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (gender == selectedGender) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary,
            contentColor = if (gender == selectedGender) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary
        ),
        modifier = Modifier
           // .weight(1f) // Quita los paréntesis aquí
            .height(48.dp)
    ) {
        Text(gender)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBMICalculatorScreen() {
    BMICalculatorScreen()
}
