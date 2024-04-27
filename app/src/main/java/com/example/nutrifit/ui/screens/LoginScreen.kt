package com.example.nutrifit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") } // Estado para el correo electrónico
    var password by remember { mutableStateOf("") } // Estado para la contraseña
    val auth = FirebaseAuth.getInstance() // Instancia de FirebaseAuth

    // Definimos la estructura de la pantalla de inicio de sesión
    Column(modifier = Modifier.fillMaxSize().background(Color.White), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        // Imagen de fondo o logotipo
       // Image(painter = painterResource(id = R.drawable.nutrifit_logo), contentDescription = "Logotipo de NutriFit")

        // Espaciador
        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para el correo electrónico
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
        )

        // Espaciador
        Spacer(modifier = Modifier.height(8.dp))

        // Campo de texto para la contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                // Aquí manejarías el evento de inicio de sesión al presionar 'Done' en el teclado
            })
        )

        // Espaciador
        Spacer(modifier = Modifier.height(16.dp))

        // Botón de inicio de sesión
//        Button(onClick = {
//            // Manejo del inicio de sesión al hacer clic en el botón
//            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    // El usuario ha iniciado sesión correctamente
//                } else {
//                    // Ha ocurrido un error al intentar iniciar sesión
//                }
//            }
//        }) {
//            Text("Iniciar sesión")
//        }
    }

}



