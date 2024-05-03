package com.example.nutrifit.ui.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nutrifit.R
import com.example.nutrifit.ui.navigation.NavigationScreen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.0f,
            animationSpec = tween(durationMillis = 1000, easing = { OvershootInterpolator(8f).getInterpolation(it) })
        )
        delay(4000L)
        if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()) {
            navController.navigate(NavigationScreen.LoginScreen.route)
        } else {
            navController.navigate(NavigationScreen.FormPlanScreen.route)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .size(330.dp)
                .scale(scale.value),
            shape = CircleShape,
            color = Color.Transparent, // Fondo transparente del círculo
            border = BorderStroke(width = 2.dp, color = Color.Gray) // Borde gris
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_splashscreen), // Asegúrate de que el nombre del recurso es correcto
                contentDescription = "App Icon",
                modifier = Modifier
                    .matchParentSize() // Ajusta la imagen para llenar el círculo
                    .clip(CircleShape) // Asegura que la imagen se recorte en forma circular
            )
        }
        // Texto curvado simulado
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(15.dp)
        ) {
            Spacer(modifier = Modifier.size(35.dp)) // Ajuste el espacio para posicionar el texto
            Text(
                "NutriFit",
                style = MaterialTheme.typography.h2.copy(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Green
                ),
                modifier = Modifier.padding(horizontal = 20.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(10.dp))
//            Text(
//                "Nutrifit",
//                style = MaterialTheme.typography.h3.copy(
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.ExtraBold,
//                    color = Color.Green
//                ),
//                modifier = Modifier.padding(horizontal = 24.dp),
//                textAlign = TextAlign.Center
//            )
        }
    }
}
