package com.example.nutrifit.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutrifit.R
import androidx.compose.ui.layout.ContentScale

@Composable
fun GenderSelection(selectedGender: String, onGenderSelected: (String) -> Unit) {
    Row(modifier = Modifier.padding(10.dp)) {
        GenderButton(
            gender = "Hombre",
            iconRes = R.drawable.ic_generomasculino,
            selectedGender = selectedGender,
            onGenderSelected = onGenderSelected
        )
        Spacer(modifier = Modifier.width(50.dp))
        GenderButton(
            gender = "Mujer",
            iconRes = R.drawable.ic_generofemenino,
            selectedGender = selectedGender,
            onGenderSelected = onGenderSelected
        )
    }
}

@Composable
fun GenderButton(gender: String, iconRes: Int, selectedGender: String, onGenderSelected: (String) -> Unit) {
    Button(onClick = { onGenderSelected(gender) }) {
        Image(

            painter = painterResource(id = iconRes),
            contentDescription = "Ícono de $gender",
            modifier = Modifier.size(40.dp), // Ajusta esto para cambiar el tamaño del ícono
            contentScale = ContentScale.Fit // Mantiene la proporción del ícono al escalar
        )
        Spacer(Modifier.width(8.dp))
        Text(text = gender)
    }
}

@Preview(showBackground = true)
@Composable
fun GenderSelectionPreview() {
    GenderSelection(selectedGender = "Hombre", onGenderSelected = {})
}
