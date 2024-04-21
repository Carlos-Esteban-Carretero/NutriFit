package com.example.nutrifit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
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

    // Cargar la imagen de fondo
    val backgroundImage: Painter = painterResource(id = R.drawable.imagen_bg_calculadora_imc)

    // Primer plano semitransparente verde
    val greenSemiTransparent = Brush.verticalGradient(
        colors = listOf(
            Color(0xCC388E3C),
            Color(0xCC81C784),
            Color(0xCCA5D6A7),
            Color(0xCC4CAF50)
        )
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Aplicar imagen de fondo
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        // Aplicar degradado verde semitransparente
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(greenSemiTransparent)
        )

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
                onClick = { /* Lógica de cálculo del IMC */ },
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
                    modifier = Modifier.size(24.dp)
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
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(label) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
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
