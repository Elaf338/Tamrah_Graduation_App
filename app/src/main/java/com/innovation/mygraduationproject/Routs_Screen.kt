package com.innovation.mygraduationproject

object Routes {
    const val SPLASH = "splash"
    const val HOME = "home"
    const val SEARCH = "search"
    const val CAMERA = "camera"
    const val SETTINGS = "settings"

    const val HELP = "help"
    const val ABOUT = "about"
    const val PRIVACY = "privacy"

    const val DETAILS = "details/{id}"
    fun details(id: String) = "details/$id"
}