package com.innovation.mygraduationproject.data

data class DateNutrition(
    val caloriesKcal: Int,
    val carbsPercent: Int,
    val fiberPercent: Int,
    val minerals: String
)

data class DateType(
    val id: String,
    val nameAr: String,
    val nameEn: String,

    val regionAr: String,
    val regionEn: String,

    val generalDescAr: String,
    val generalDescEn: String,

    val colorAr: String,
    val colorEn: String,
    val textureAr: String,
    val textureEn: String,
    val sizeAr: String,
    val sizeEn: String,

    val freshnessTipsAr: List<String>,
    val freshnessTipsEn: List<String>,

    val usesAr: List<String>,
    val usesEn: List<String>,

    val nutrition: DateNutrition,

    val imageResName: String
)