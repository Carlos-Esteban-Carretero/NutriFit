package com.example.nutrifit.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nutrifit.R

@Composable
fun GenderSelection(selectedGender: String, onGenderSelected: (String) -> Unit) {
    Row(modifier = Modifier.padding(10.dp)) {
        GenderButton(
            gender = "Hombre",
            iconRes = R.drawable.ic_generomasculino,
            selectedGender = selectedGender,
            onGenderSelected = onGenderSelected,
            isSelected = selectedGender == "Hombre"
        )
        Spacer(modifier = Modifier.width(16.dp))
        GenderButton(
            gender = "Mujer",
            iconRes = R.drawable.ic_generofemenino,
            selectedGender = selectedGender,
            onGenderSelected = onGenderSelected,
            isSelected = selectedGender == "Mujer"
        )
    }
}

@Composable
fun GenderButton(gender: String, iconRes: Int, selectedGender: String, onGenderSelected: (String) -> Unit, isSelected: Boolean) {
    val backgroundColor = if (isSelected) Color(0xFF3F51B5) else Color.Magenta
    Button(
        onClick = { onGenderSelected(gender) },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        modifier = Modifier
            .clip(RoundedCornerShape(50)) // Redondeado para los bordes del botón
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "Ícono de $gender",
            modifier = Modifier.size(50.dp), // Ajuste del tamaño del ícono
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.width(3.dp))
        Text(
            text = gender,
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black // Texto en color negro
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFE0E0E0)
@Composable
fun GenderSelectionPreview() {
    GenderSelection(selectedGender = "Hombre", onGenderSelected = {})
}
