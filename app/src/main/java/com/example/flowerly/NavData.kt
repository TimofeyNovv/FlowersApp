package com.example.flowerly

sealed class NavData(val route: String) {
    object Start : NavData("welcome_screen")
    object SignUp : NavData("signup_screen")
    object Login : NavData("login_screen")
    object Main : NavData("main_screen")

    companion object {
        val START = Start
        val SINGUP = SignUp
        val LOGIN = Login
        val MAIN = Main
    }
}