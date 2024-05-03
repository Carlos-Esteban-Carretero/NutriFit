package com.example.nutrifit.ui.views

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nutrifit.data.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)
    fun signInWhitEmailAndPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("Nutrifit", "signInWithEmailAndPassword logueado!!")
                        home()
                    } else {
                        Log.d("Nutrifit", "signInWithEmailAndPassword: ${task.result.toString()}")
                    }
                }
            } catch (ex: Exception) {
                Log.d("Nutrifit", "signInWithEmailAndPassword: ${ex.message}")
            }
        }

    fun createUserWithEmailAndPassword(email: String, password: String, home: () -> Unit) {
        if (_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val displayName = task.result.user?.email?.split("@")?.get(0)
                    createUser(displayName)
                    home()
                } else {
                    Log.d("Mascota Feliz", "CreateUserWithEmailAndPassword: ${task.result.toString()}")
                }
                _loading.value = false
            }
        }
    }

    private fun createUser(displayName: String?) {
        val userId = auth.currentUser?.uid
//        val user = mutableMapOf<String, Any>()
//
//        user["user_id"] = userId.toString()
//        user["display_name"] = displayName.toString()

        // Usando un data class
        val user = User(
            userId = userId.toString(),
            displayName = displayName.toString(),
            avatarUrl = "",
            quote = "Lo dificil ya paso",
            profession = "Android Dev",
            id = null
        ).toMap()

        FirebaseFirestore.getInstance().collection("users").add(user).addOnSuccessListener {
            Log.d("MascotaFeliz", "Creado ${it.id}")
        }.addOnFailureListener {
            Log.d("MascotaFeliz", "Ocurrio error ${it}")
        }
    }
}



