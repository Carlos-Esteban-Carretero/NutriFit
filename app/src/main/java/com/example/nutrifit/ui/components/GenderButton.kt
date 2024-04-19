package com.example.nutrifit.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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