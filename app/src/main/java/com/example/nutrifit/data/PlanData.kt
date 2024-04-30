package com.example.nutrifit.data

import com.google.firebase.firestore.DocumentReference

data class Plan(
    val name: String = "",
    val schedule: Map<String, Map<String, DocumentReference>> = mapOf()
)
