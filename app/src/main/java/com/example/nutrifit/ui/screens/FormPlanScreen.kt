package com.example.nutrifit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ContentAlpha
import com.example.nutrifit.R
import com.example.nutrifit.ui.components.GenderSelection

@Composable
fun FormPlanScreen() {
    var gender by remember { mutableStateOf("Hombre") }
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF388E3C), // Verde oscuro
                        Color(0xFF81C784), // Verde claro
                        Color(0xFFA5D6A7), // Verde aún más claro
                        Color(0xFF4CAF50)  // Otro tono de verde
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Calculadora IMC",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Seleccione su género:",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif
                )
            )
            GenderSelection(gender, onGenderSelected = { gender = it })
            CustomOutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = "Edad",
                icon = R.drawable.ic_edad,
                keyboardType = KeyboardType.Number
            )
            CustomOutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = "Altura (cm)",
                icon = R.drawable.ic_altura,
                keyboardType = KeyboardType.Number
            )
            CustomOutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = "Peso (kg)",
                icon = R.drawable.ic_peso,
                keyboardType = KeyboardType.Number
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { /* Aquí iría la lógica para el cálculo del IMC */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calculadora_calcular),
                    contentDescription = "Calcular",
                    modifier = Modifier.size(25.dp)


                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "Calcular",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: Int,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue -> onValueChange(newValue) },
        singleLine = true,
        label = { Text(label) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label, // Usamos label como contentDescription
                modifier = Modifier.size(24.dp)
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.Transparent,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium)
        ),
        shape = RoundedCornerShape(50.dp),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun FormPlanScreenPreview() {
    FormPlanScreen()
}
