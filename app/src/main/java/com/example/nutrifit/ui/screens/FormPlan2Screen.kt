package com.example.nutrifit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FormPlan2Screen() {
    val activityLevels = listOf(
        "Sedentario -> (Nada o poco ejercicio)(1700Kcal)",
        "Ligero -> (2-3 días por semana)(1900Kcal)",
        "Moderado -> (4-5 días por semana)(2300Kcal)",
        "Alto -> (6-7 días por semana)(2700Kcal)",
        "Atleta -> (+6 días por semana)(3100Kcal)"
    )
    val dietOptions = listOf(
        "Dieta de bajada de peso (Dieta Hipocalórica)",
        "Dieta de subida de peso (Dieta Hipercalórica)",
        "Dieta de mantenimiento (Tener una alimentación más saludable)"
    )
    var expandedActivity by remember { mutableStateOf(false) }
    var expandedDiet by remember { mutableStateOf(false) }
    var selectedIndexActivity by remember { mutableStateOf(0) }
    var selectedIndexDiet by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "¿Cuál es tu nivel de actividad física?",
            color = Color.Blue,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(16.dp))
        ExposedDropdownMenuBox(
            expanded = expandedActivity,
            onExpandedChange = {
                expandedActivity = !expandedActivity
            }
        ) {
            TextField(
                value = activityLevels[selectedIndexActivity],
                onValueChange = { },
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Desplegar",
                        modifier = Modifier.clickable { expandedActivity = !expandedActivity }
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White.copy(alpha = 0.8f),
                    textColor = MaterialTheme.colors.onSurface,
                    disabledTextColor = Color.Transparent,
                    cursorColor = MaterialTheme.colors.onSurface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray)
            )
            DropdownMenu(
                expanded = expandedActivity,
                onDismissRequest = {
                    expandedActivity = false
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                activityLevels.forEachIndexed { index, level ->
                    DropdownMenuItem(
                        onClick = {
                            selectedIndexActivity = index
                            expandedActivity = false
                        }
                    ) {
                        Text(text = level,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colors.onSurface)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            "¿Cuál es la dieta que desea llevar a cabo?",
            color = Color.Green,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(16.dp))
        ExposedDropdownMenuBox(
            expanded = expandedDiet,
            onExpandedChange = {
                expandedDiet = !expandedDiet
            }
        ) {
            TextField(
                value = dietOptions[selectedIndexDiet],
                onValueChange = { },
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Desplegar",
                        modifier = Modifier.clickable { expandedDiet = !expandedDiet }
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White.copy(alpha = 0.8f),
                    textColor = MaterialTheme.colors.onSurface,
                    disabledTextColor = Color.Transparent,
                    cursorColor = MaterialTheme.colors.onSurface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray)
            )

            DropdownMenu(
                expanded = expandedDiet,
                onDismissRequest = {
                    expandedDiet = false
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                dietOptions.forEachIndexed { index, diet ->
                    DropdownMenuItem(
                        onClick = {
                            selectedIndexDiet = index
                            expandedDiet = false
                        }
                    ) {
                        Text(
                            text = diet,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colors.onSurface)
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("Advertencia:")
                }
            },
            color = Color.Yellow,
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(8.dp) // o cualquier otro modificador que necesites
        )

        Text(
            "La aplicación proporciona información general sobre nutrición y hábitos alimenticios saludables. " +
                    "Sin embargo, si usted es intolerante a algún alimento o tiene necesidades dietéticas específicas, se " +
                    "recomienda encarecidamente que consulte a un profesional médico calificado antes de seguir cualquier " +
                    "plan alimenticio proporcionado por la aplicación. Cada persona tiene necesidades únicas y es fundamental " +
                    "recibir orientación personalizada para garantizar una alimentación adecuada y segura.",
            color = Color.White,
            fontSize = 17.sp,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(8.dp)
        )
        // Espacio adicional si es necesario entre el texto de advertencia y el botón
        Spacer(modifier = Modifier.height(16.dp))

        // Botón de acción para continuar
        Button(
            onClick = { /* TODO: Acción que se realizará al pulsar el botón */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            ),


            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 55.dp)
                .height(60.dp)
        ) {
            Text(
                text = "¿Estás listo?\nComencemos",
                fontSize = 19.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FormPlan2ScreenPreview() {
    MaterialTheme {
        FormPlan2Screen()
    }
}
