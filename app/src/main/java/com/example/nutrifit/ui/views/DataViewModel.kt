package com.example.nutrifit.ui.views

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nutrifit.data.Plan
import com.example.nutrifit.data.Recipe
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DataViewModel : ViewModel() {
    private val _recipes = mutableStateOf(emptyList<Recipe>())
    val recipes = _recipes
    private val _plans = mutableStateOf(emptyList<Plan>())
    val plans = _plans

    init {
        fetchAllRecipes()
        fetchAllPlans()
    }

    private fun fetchAllRecipes() {
        viewModelScope.launch {
            val allRecipes = getAllRecipesFromFirestore()
            _recipes.value = allRecipes
        }
    }

    private fun fetchAllPlans() {
        viewModelScope.launch {
            val allPlans = getAllPlansFromFirestore()
            _plans.value = allPlans
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


    private suspend fun getAllPlansFromFirestore(): List<Plan> {
        val firestoreDb = FirebaseFirestore.getInstance()

        return try {
            val querySnapshot = firestoreDb.collection("plans").get().await()
            querySnapshot.documents.mapNotNull { it.toObject(Plan::class.java) }
        } catch (e: FirebaseFirestoreException) {
            Log.d("DataVieModel", "Error fetching all plans: $e")
            emptyList()
        }
    }

  fun getRecipeDetailsFromPlan(plan: Plan, day: String, meal: String):Recipe? {
        val recipeReference = plan.schedule[day]?.get(meal)
        return if (recipeReference != null) {
            getRecipeFromReference(recipeReference)
        } else {
            null
        }
    }

    private suspend fun getRecipeFromReference(documentReference: DocumentReference): Recipe? {
        return try {
            val documentSnapshot = documentReference.get().await()
            documentSnapshot.toObject(Recipe::class.java)
        } catch (e: FirebaseFirestoreException) {
            Log.d("DataVieModel", "Error fetching recipe: $e")
           null
        }

    }
}