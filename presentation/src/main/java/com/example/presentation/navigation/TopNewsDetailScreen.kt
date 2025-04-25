package com.example.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newsdetail.HouseMemberDetailScreen
import com.example.presentation.util.Constants.DETAILS_ROUTE
import com.example.presentation.util.Constants.ID

fun NavController.navigateToDetails(id:String){
    val route = "${Screen.Details}/$id"
    navigate(route)
}

fun NavGraphBuilder.topNewsDetailScreen(onBack: () -> Unit){
    composable(
        route = DETAILS_ROUTE,
        arguments = listOf(
            navArgument(name = ID){
                type = NavType.StringType
            },
        ),
    ) { navBackStackEntry ->
        val id  = navBackStackEntry.arguments?.getString(ID).orEmpty()
        HouseMemberDetailScreen(id = id){
            onBack()
        }
    }
}