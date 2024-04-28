package com.example.nutrifit.ui.views

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)
    // Inicializa Firebase Auth, etc.

    fun signInWhitEmailAndPassword(email: String, password: String, home: () -> Unit)
        = viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d("Mascota Feliz", "signInWithEmailAndPassword logueado!!")
                            home()
                        } else {
                            Log.d(
                                "Mascota Feliz",
                                "signInWithEmailAndPassword: ${task.result.toString()}"
                            )

                        }
                    }
            } catch (ex: Exception) {
                Log.d("Mascota Feliz", "signInWithEmailAndPassword: ${ex.message}")
            }
        }
    }



