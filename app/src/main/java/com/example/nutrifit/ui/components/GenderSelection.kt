package com.example.nutrifit.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenderSelection(selectedGender: String, onGenderSelected: (String) -> Unit) {
    Row(modifier = Modifier.padding(16.dp)) {
        GenderButton(gender = "Hombre", selectedGender = selectedGender, onGenderSelected = onGenderSelected)
        Spacer(modifier = Modifier.width(8.dp))
        GenderButton(gender = "Mujer", selectedGender = selectedGender, onGenderSelected = onGenderSelected)
    }
}