package com.example.nutrifit.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nutrifit.R
import com.example.nutrifit.ui.components.GenderSelection
import com.example.nutrifit.ui.navigation.NavigationScreen
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.math.pow

@Composable
fun FormPlanScreen(navController: NavHostController) {
    var gender by remember { mutableStateOf("Hombre") }
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var imcResult by remember { mutableStateOf<Double?>(null) }
    var imcClassification by remember { mutableStateOf("") }
    var imcColor by remember { mutableStateOf(Color.White) }

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Calculadora IMC", style = MaterialTheme.typography.headlineMedium.copy(fontSize = 40.sp, color = Color.White, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif))
            Spacer(modifier = Modifier.height(12.dp))
            Text("Seleccione su género:", style = MaterialTheme.typography.bodyLarge.copy(fontSize = 22.sp, color = Color.White, fontFamily = FontFamily.SansSerif))
            GenderSelection(gender, onGenderSelected = { gender = it })
            CustomOutlinedTextField(value = age, onValueChange = { age = it }, label = "Edad", icon = R.drawable.ic_edad, keyboardType = KeyboardType.Number)
            CustomOutlinedTextField(value = height, onValueChange = { height = it }, label = "Altura (cm)", icon = R.drawable.ic_altura, keyboardType = KeyboardType.Number)
            CustomOutlinedTextField(value = weight, onValueChange = { weight = it }, label = "Peso (kg)", icon = R.drawable.ic_peso, keyboardType = KeyboardType.Number)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (height.isNotEmpty() && weight.isNotEmpty() && height.toDoubleOrNull() != null && weight.toDoubleOrNull() != null) {
                    val heightMeters = height.toDouble() / 100
                    val weightKg = weight.toDouble()
                    val imc = weightKg / (heightMeters.pow(2))
                    imcResult = imc
                    when {
                        imc < 18.5 -> {
                            imcClassification = "Bajo peso"
                            imcColor = Color.Yellow
                        }
                        imc < 25 -> {
                            imcClassification = "Peso normal"
                            imcColor = Color.Green
                        }
                        imc < 30 -> {
                            imcClassification = "Sobrepeso"
                            imcColor = Color.Yellow
                        }
                        imc < 35 -> {
                            imcClassification = "Obesidad Grado I"
                            imcColor = Color(0xFFFFA500) // Naranja
                        }
                        imc < 40 -> {
                            imcClassification = "Obesidad Grado II"
                            imcColor = Color.Red
                        }
                        else -> {
                            imcClassification = "Obesidad Grado III"
                            imcColor = Color.Red
                        }
                    }
                } else {
                    imcResult = null
                    imcClassification = "Por favor ingresa tu altura y peso correctamente."
                }
            }, modifier = Modifier.fillMaxWidth().height(60.dp), shape = RoundedCornerShape(50), colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)) {
                Text("Calcular", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            imcResult?.let { imc ->
                val formattedImc = "%.2f".format(imc)
                Text("Tu IMC es: $formattedImc (${imcClassification})", color = imcColor, style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), modifier = Modifier.padding(top = 16.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if (imcResult != null) {
                        saveUserDataToFirebase(age, height, weight, imcResult, imcClassification)
                        navController.navigate(NavigationScreen.FormPlan2Screen.route)
                    }
                },
                enabled = imcResult != null, modifier = Modifier.fillMaxWidth().height(48.dp), shape = RoundedCornerShape(50), colors =  ButtonDefaults.buttonColors(
                    Color.Red)) {
                Text("Siguiente", color = Color.White, fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("Información sobre el IMC", color = Color.White, style = MaterialTheme.typography.bodyLarge)
            Text("El Índice de Masa Corporal (IMC) es una medida de la grasa corporal basada en la altura y el peso que se aplica tanto a hombres como a mujeres.", color = Color.White, style = MaterialTheme.typography.bodySmall)
            Text("Fórmula del IMC: IMC = Peso (kg) / (Altura (m) x Altura (m))", color = Color.White, style = MaterialTheme.typography.bodySmall)
        }
    }
}
fun saveUserDataToFirebase(age: String, height: String, weight: String, imc: Double?, imcClassification: String) {
    val userId = "obtener_de_algún_lugar" // Asegúrate de tener un ID de usuario
    val userMap = mutableMapOf(
        "age" to age,
        "height" to height,
        "weight" to weight,
        "imc" to imc,
        "imc_classification" to imcClassification
    )

    val databaseReference = Firebase.firestore.collection("users").document(userId)
    databaseReference.set(userMap)
        .addOnSuccessListener {
            Log.d("Firebase", "Datos guardados correctamente!")
        }
        .addOnFailureListener { e ->
            Log.w("Firebase", "Error al guardar los datos", e)
        }
}

@Composable
fun GenderSelection(gender: String, onGenderSelected: (String) -> Unit) {
    // Implementación del selector de género (debes agregar la lógica interna)
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
        label = { Text(label, color = Color.White) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Color.White,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = Color.Gray,
            focusedTextColor = Color.White,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.Gray,
            focusedPlaceholderColor = Color.Gray,
            unfocusedTextColor = Color.White,
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        modifier = Modifier.fillMaxWidth()
    )
}


@Preview(showBackground = true)
@Composable
fun FormPlanScreenPreview() {
    val navController = rememberNavController() // Crea un NavController dummy
    FormPlanScreen(navController) // Pasa el NavController dummy
}
