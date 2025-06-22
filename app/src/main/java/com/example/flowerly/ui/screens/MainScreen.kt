package com.example.flowerly.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onLogout: () -> Unit,

    ) {
    Text(text = "main Screen")
}