package com.example.nutrifit.ui.views

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nutrifit.data.Recipe
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DataViewModel : ViewModel() {
    val state = mutableStateOf(emptyList<Recipe>())


    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            val data = getAllDataFromFireStore()
            state.value = data
    }
    val pepe = true
    if (pepe) {
        Log.d("hola", "rober")
    }
}

private suspend fun getAllDataFromFireStore(): List<Recipe> {
        val db = FirebaseFirestore.getInstance()

        return try {
            val result = db.collection("recipes").get().await()
            result.documents.mapNotNull { it.toObject(Recipe::class.java) }
        } catch (e: FirebaseFirestoreException) {
            Log.d("error", "getAllDataFromFireStore: $e")
            emptyList()
        }
    }

    suspend fun getRecipesDataByName(RecipesName: String): Recipe? {
        val db = FirebaseFirestore.getInstance()

        return try {
            val snapshot = db.collection("LunesBajadaPeso")
                .whereEqualTo("Title", RecipesName)
                .get()
                .await()

            if (!snapshot.isEmpty) {
                val document = snapshot.documents[0]
                document.toObject(Recipe::class.java)
            } else {
                null
            }
        } catch (e: FirebaseFirestoreException) {
            Log.d("error", "getRecipesDataByName: $e")
            null
        }
    }
}
