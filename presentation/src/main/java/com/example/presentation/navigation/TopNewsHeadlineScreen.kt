package com.example.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.topnewsheadline.TopHeadlineScreen

fun NavGraphBuilder.topNewsHeadlineScreen(navigationToDetail: (id:String) -> Unit){
    composable(route = Screen.Home.route) {
        TopHeadlineScreen(navigationToDetail = navigationToDetail)
    }
}