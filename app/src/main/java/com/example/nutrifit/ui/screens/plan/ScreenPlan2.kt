package com.example.nutrifit.ui.screens.plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutrifit.R
import com.example.nutrifit.ui.components.ScreenWithBottomBar

// Asumiendo que los identificadores de los drawables son correctos y corresponden a los nombres de archivos.
val objectives = listOf(
    ObjectiveItem("Perder Grasa", "Maximiza la pérdida de grasa y conserva tu masa muscular", R.drawable.ic_perder_peso),
    ObjectiveItem("Mantener Peso", "Conserva tu estado físico y mantente saludable", R.drawable.ic_mantener_peso),
    ObjectiveItem("Ganar Músculo", "Incrementa tu masa muscular y vuélvete más fuerte", R.drawable.ic_ganar_musculo),
)

data class ObjectiveItem(val title: String, val description: String, val iconId: Int)

@Composable
fun ScreenPlan2() {
    ScreenWithBottomBar(
        selectedItem = 0, // Asegúrate de que este índice corresponda con la pestaña 'Plan'.
        onItemSelected = { index ->
            // Acción cuando se selecciona un ítem
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
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
}

@Composable
fun ObjectiveOption(objective: ObjectiveItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Maneja el clic en cada objetivo aquí */ }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = objective.iconId),
            contentDescription = objective.title,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = objective.title,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = objective.description,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreenPlan2() {
    ScreenPlan2()
}
