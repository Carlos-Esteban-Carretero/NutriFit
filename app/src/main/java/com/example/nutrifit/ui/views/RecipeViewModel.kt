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

class RecipeViewModel : ViewModel() {
    private val _recipes = mutableStateOf(emptyList<Recipe>())
    val recipes = _recipes

    init {
        fetchAllRecipes()
    }

    private fun fetchAllRecipes() {
        viewModelScope.launch {
            val allRecipes = getAllRecipesFromFirestore()
            _recipes.value = allRecipes
        }
    }

    private suspend fun getAllRecipesFromFirestore(): List<Recipe> {
        val firestoreDb = FirebaseFirestore.getInstance()

        return try {
            val querySnapshot = firestoreDb.collection("recipes").get().await()
            querySnapshot.documents.mapNotNull { it.toObject(Recipe::class.java) }
        } catch (e: FirebaseFirestoreException) {
            Log.d("RecipeViewModel", "Error fetching all recipes: $e")
            emptyList()
        }
    }

    suspend fun findRecipeByName(recipeName: String): Recipe? {
        val firestoreDb = FirebaseFirestore.getInstance()

        return try {
            val querySnapshot = firestoreDb.collection("recipes")
                .whereEqualTo("name", recipeName)
                .get()
                .await()

            if (querySnapshot.isEmpty) {
                null
            } else {
                val document = querySnapshot.documents[0]
                document.toObject(Recipe::class.java)
            }
        } catch (e: FirebaseFirestoreException) {
            Log.d("RecipeViewModel", "Error finding recipe by name: $e")
            null
        }
    }
}
