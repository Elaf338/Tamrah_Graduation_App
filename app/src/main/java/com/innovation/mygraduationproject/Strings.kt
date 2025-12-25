package com.innovation.mygraduationproject

data class Strings(
    val appName: String,

    // Home
    val heroTitle: String,
    val heroSubtitle: String,

    // Details
    val regions: String,
    val color: String,
    val uses: String,
    val nutrition: String,
    val extra: String,

    // Common
    val back: String,

    // Camera
    val pickFromGallery: String,
    val takePhotoNow: String
)

fun stringsFor(lang: Language): Strings = when (lang) {

    Language.AR -> Strings(
        appName = "إكسبلور",

        // Home
        heroTitle = "اكتشف تراث تمور السعودية",
        heroSubtitle = "التمور جزء من ثقافتنا، لكل نوع طعم وفائدة واستخدام مختلف.",

        // Details
        regions = "أشهر المناطق",
        color = "اللون",
        uses = "الاستخدامات",
        nutrition = "القيمة الغذائية (تقريبية لكل 100g)",
        extra = "معلومات إضافية",

        // Common
        back = "رجوع",

        // Camera
        pickFromGallery = "الالبوم",
        takePhotoNow = "كاميرا"
    )

    Language.EN -> Strings(
        appName = "Explore",

        // Home
        heroTitle = "Discover Saudi Dates Heritage",
        heroSubtitle = "Dates are part of our culture. Each type has its own taste and benefits.",

        // Details
        regions = "Common regions",
        color = "Color",
        uses = "Uses",
        nutrition = "Nutrition (approx. per 100g)",
        extra = "Extra info",

        // Common
        back = "Back",

        // Camera
        pickFromGallery = "ALBUM",
        takePhotoNow = "CAMERA"
    )
}