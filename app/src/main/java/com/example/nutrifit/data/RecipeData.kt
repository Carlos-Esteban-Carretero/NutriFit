package com.example.nutrifit.data

data class Recipe (
    val name: String = "",
    val description: String = "",
    val image: String = "",
    val calories: Int = 0,
    val carbohydrates: Int = 0,
    val fats: Int = 0,
    val proteins: Int = 0,
)
