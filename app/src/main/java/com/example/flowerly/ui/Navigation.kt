package com.example.flowerly.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flowerly.NavData
import com.example.flowerly.ui.screens.LogInScreen
import com.example.flowerly.ui.screens.MainScreen
import com.example.flowerly.ui.screens.SingUpScreen
import com.example.flowerly.ui.screens.WelcomeScreen

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    var authToken by remember { mutableStateOf<String?>(null) }

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

        composable(NavData.Login.route) {
            LogInScreen(
                onBack = { navController.popBackStack() },
                onLoginSuccess = { token ->
                    authToken = token // Сохраняем токен
                    navController.navigate(NavData.MAIN.route) {
                        popUpTo(NavData.Login.route)
                    }
                }
            )
        }

        composable(NavData.MAIN.route) {
            MainScreen(
                onLogout = {
                    authToken = null
                    navController.navigate(NavData.START.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}