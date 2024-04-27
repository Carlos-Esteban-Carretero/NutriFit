package com.example.nutrifit.ui.views

import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    // Inicializa Firebase Auth, etc.

    fun signIn(email: String, password: String) {
        // Lógica para iniciar sesión con Firebase Auth
    }

    fun signUp(email: String, password: String) {
        // Lógica para registrar un nuevo usuario con Firebase Auth
    }

    fun signInWithGoogle() {
        // Lógica para iniciar sesión con Google Sign-In y Firebase Auth
    }
}

