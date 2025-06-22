package com.example.flowerly.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flowerly.NavData
import com.example.flowerly.ui.screens.LogInScreen
import com.example.flowerly.ui.screens.SingUpScreen
import com.example.flowerly.ui.screens.WelcomeScreen

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = NavData.START.route,
        modifier = modifier
    ) {
        // Welcome Screen
        composable(NavData.START.route) {
            WelcomeScreen(
                onSignUpClick = { navController.navigate(NavData.SignUp.route) },
                onLoginClick = { navController.navigate(NavData.Login.route) }
            )
        }

        // SignUp Screen
        composable(NavData.SignUp.route) {
            SingUpScreen(
                onBack = { navController.popBackStack() },
                onSignUpComplete = {
                    navController.navigate(NavData.Login.route) {
                        popUpTo(NavData.START.route)
                    }
                }
            )
        }

        // Login Screen
        composable(NavData.Login.route) {
            LogInScreen(
                onBack = { navController.popBackStack() },
                onLoginSuccess = {
                    navController.navigate("main_screen") {
                        popUpTo(0)  // Полная очистка стека
                    }
                }
            )
        }
    }
}