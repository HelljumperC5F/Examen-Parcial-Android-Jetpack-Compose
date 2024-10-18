package com.example.a512lasalleapp.ui.utils

// The `data object`
sealed class Screens(val route : String) {
    data object Home : Screens("home")
    data object Grades : Screens("grades")
    data object Calendar : Screens("calendar")
    data object Settings : Screens("settings")
    data object NewsDetail: Screens("news-detail")
    data object ClassDetails: Screens("class-detail")
    data object Empty: Screens("empty")
    data object Pagos: Screens("pagos")
}