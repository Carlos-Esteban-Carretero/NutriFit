package com.example.nutrifit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutrifit.R
import com.example.nutrifit.ui.components.ActivityLevelItem
import com.example.nutrifit.ui.components.GenderSelection
import com.example.nutrifit.ui.components.ObjectiveButton
import com.example.nutrifit.ui.components.ObjectiveOption


// ****************************************** FormScreen1 ******************************************

// Define los niveles de actividad física como una enumeración o lista de datos
val activityLevels = listOf(
    "Sedentario - Nada o poco ejercicio",
    "Ligero - Ejercicio 2-3 días por semana",
    "Moderado - Ejercicio 4-5 días por semana",
    "Alto - Ejercicio 6-7 días por semana",
    "Atleta Profesional - Ejercicio intenso 6-7 días por semana"
)

@Composable
fun FormPlanScreen1() {
    var selectedActivityLevel by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¿Cuál es tu nivel de actividad física?",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )
        activityLevels.forEach { level ->
            ActivityLevelItem(
                level = level,
                selected = level == selectedActivityLevel,
                onSelect = { selectedActivityLevel = level }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormPlanScreen1Preview() {
    FormPlanScreen1()
}




// ****************************************** FormScreen2 ******************************************

// Asumiendo que los identificadores de los drawables son correctos y corresponden a los nombres de archivos.
val objectives = listOf(
    ObjectiveItem(
        "Perder Grasa",
        "Maximiza la pérdida de grasa y conserva tu masa muscular",
        R.drawable.ic_perder_peso
    ),
    ObjectiveItem(
        "Mantener Peso",
        "Conserva tu estado físico y mantente saludable",
        R.drawable.ic_mantener_peso
    ),
    ObjectiveItem(
        "Ganar Músculo",
        "Incrementa tu masa muscular y vuélvete más fuerte",
        R.drawable.ic_ganar_musculo
    ),
)

data class ObjectiveItem(val title: String, val description: String, val iconId: Int)

@Composable
fun FormPlanScreen2() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_cual_es_tu_objetivo),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // Fondo oscuro para mejorar el contraste
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Black.copy(alpha = 0.7f), Color.Transparent),
                        startY = 300f // Puedes ajustar este valor según tus necesidades
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopStart)
        ) {
            objectives.forEach { objective ->
                ObjectiveOption(objective)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormPlanScreen2Preview() {
    FormPlanScreen2()
}




// ****************************************** FormScreen3 ******************************************

@Composable
fun FormPlanScreen3() {
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


@Preview(showBackground = true)
@Composable
fun PreviewBMICalculatorScreen() {
    FormPlanScreen3()
}




// ****************************************** FormScreen4 ******************************************

@Composable
fun FormScreen4() {
    var intolerancia by remember { mutableStateOf(false) }
    var detallesIntolerancia by remember { mutableStateOf("") }
    var dietaSeleccionada by remember { mutableStateOf("") }
    val dietas = listOf("Dieta baja en calorías", "Dieta alta en calorías", "Dieta de mantenimiento")
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.intolerancia_alimentos),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        IntoleranciaInput(intolerancia, onCheckedChange = { intolerancia = it })

        if (intolerancia) {
            DetallesIntoleranciaInput(detallesIntolerancia, onValueChange = { detallesIntolerancia = it })
        }

        Text(
            text = stringResource(R.string.selecciona_dieta),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        DietasOptions(dietas, dietaSeleccionada, onDietaSelected = { dietaSeleccionada = it })
    }
}

@Composable
fun IntoleranciaInput(intolerancia: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.pregunta_intolerancia),
                style = MaterialTheme.typography.bodyLarge
            )
            Row {
                Switch(
                    checked = intolerancia,
                    onCheckedChange = onCheckedChange
                )
            }
        }
    }
}

@Composable
fun DetallesIntoleranciaInput(detalles: String, onValueChange: (String) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.instrucciones_intolerancia),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            BasicTextField(
                value = detalles,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(4.dp))
                    .padding(8.dp),
            )
        }
    }
}

@Composable
fun DietasOptions(dietas: List<String>, selectedDieta: String, onDietaSelected: (String) -> Unit) {
    dietas.forEach { dieta ->
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(2.dp)

        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedDieta == dieta,
                    onClick = { onDietaSelected(dieta) }
                )
                Text(
                    text = dieta,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormScreen4Preview() {
    FormScreen4()
}




// ****************************************** FormScreen5 ******************************************

@Composable
fun FormPlanScreen5() {
    // Valores de ejemplo, estos se actualizarían con la lógica real de tu aplicación
    val ejemploImc = "23.4"
    val descripcionImc = "según la OMS está dentro del rango normal."

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA5D6A7)) // Color de fondo verde
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¿CUÁL ES TU OBJETIVO?",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Botones de objetivos (Perder peso, Ganar peso, Vida saludable)
        ObjectiveButton(
            text = "Perder peso",
            onClick = { /* TODO: Handle perder peso */ }
        )
        ObjectiveButton(
            text = "Ganar peso",
            onClick = { /* TODO: Handle ganar peso */ }
        )
        ObjectiveButton(
            text = "Vida saludable",
            onClick = { /* TODO: Handle vida saludable */ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Su Índice De Masa Corporal es: $ejemploImc",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = " Su IMC $descripcionImc",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewObjectivesUserScreen() {
    FormPlanScreen5()
}
