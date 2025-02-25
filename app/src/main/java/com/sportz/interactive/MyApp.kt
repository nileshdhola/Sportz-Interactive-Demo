package com.sportz.interactive

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.sportz.interactive.presentation.Navigation

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Navigation(navController)
}