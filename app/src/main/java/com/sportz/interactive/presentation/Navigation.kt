package com.sportz.interactive.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sportz.interactive.presentation.ui.match.MatchScreen
import com.sportz.interactive.presentation.ui.squad.SquadScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = "matchScreen") {
        composable("matchScreen") { MatchScreen(navController) }
        composable("squadScreen") { SquadScreen() }
    }
}