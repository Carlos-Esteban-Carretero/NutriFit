package com.example.nutrifit.ui.views

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nutrifit.data.Plan
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class PlanViewModel : ViewModel() {
    private val _plans = mutableStateOf(emptyList<Plan>())
    val plans = _plans

    init {
        fetchAllPlans()
    }

    private fun fetchAllPlans() {
//        viewModelScope.launch {
//            val allPlans = getAllPlansFromFirestore()
//            _plans.value = allPlans
//        }
        val firestoreDb = FirebaseFirestore.getInstance()
        val querySnapshot = firestoreDb.collection("plans").get().await()
        querySnapshot.documents.mapNotNull { it.toObject(Plan::class.java) }
        val pepe = true
        if (pepe){
            Log.d("PlanViewModel", "Test")
        }
    }

    private suspend fun getAllPlansFromFirestore(): List<Plan> {
        val firestoreDb = FirebaseFirestore.getInstance()

        return try {
            val querySnapshot = firestoreDb.collection("plans").get().await()
            querySnapshot.documents.mapNotNull { it.toObject(Plan::class.java) }
        } catch (e: FirebaseFirestoreException) {
            Log.d("PlanViewModel", "Error fetching all plans: $e")
            emptyList()
        }
    }
}
