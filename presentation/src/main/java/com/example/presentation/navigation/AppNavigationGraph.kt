package com.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        topNewsHeadlineScreen(navHostController::navigateToDetails)
        topNewsDetailScreen(navHostController::popBackStack)
    }
}