//package com.example.nutrifit.ui.screens
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LoginPruebasScreen(authViewModel: AuthViewModel) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var passwordVisibility by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Usuario", color = Color.White) },
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedTextColor =  Color.White,
//                focusedBorderColor = Color.Gray,
//                unfocusedBorderColor = Color.DarkGray
//            )
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Contraseña", color = Color.White) },
//            singleLine = true,
//            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
//            trailingIcon = {
//                val image = if (passwordVisibility)
//                    Icons.Filled.Visibility
//                else Icons.Filled.VisibilityOff
//
//                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
//                    Icon(imageVector = image, "Toggle password visibility", tint = Color.White)
//                }
//            },
//            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//               focusedTextColor  = Color.White,
//                focusedBorderColor = Color.Gray,
//                unfocusedBorderColor = Color.DarkGray
//            )
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = { authViewModel.signIn(email, password) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
//        ) {
//            Text("Iniciar sesión", fontSize = 16.sp, color = Color.White)
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Button(
//            onClick = { authViewModel.signUp(email, password) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
//        ) {
//            Text("Crear cuenta", fontSize = 16.sp, color = Color.White)
//        }
//    }
//}
//@Preview(showBackground = true)
//@Composable
//fun LoginPruebasScreenPreview() {
//    MaterialTheme {
//        // Imagina que estás llamando a tu pantalla de inicio de sesión real aquí
//        LoginPruebasScreen()
//    }
//}
//
//// Asegúrate de que tienes una función Composable que coincida con este nombre para que la vista previa funcione
//@Composable
//fun LoginPruebasScreen() {
//    // Aquí iría la implementación de tu pantalla de inicio de sesión
//    // Puedes usar el código que proporcioné anteriormente como punto de partida
//}
