package com.example.nutrifit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutrifit.R

@Composable
fun MainContent() {
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

@Preview
@Composable
fun PreviewScreenRecetas1() {
    MainContent()
}

