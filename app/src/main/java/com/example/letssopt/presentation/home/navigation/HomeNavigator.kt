package com.example.letssopt.presentation.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.common.navigation.MainTabRoute
import com.example.letssopt.presentation.home.HomeRoute
import kotlinx.serialization.Serializable

@Serializable
data object Home : MainTabRoute

fun NavController.navigateToHome(){
    navigate(
        route = Home
    )
}

fun NavGraphBuilder.homeNavFGraph(
    paddingValues: PaddingValues
){
    composable<Home> {
        HomeRoute(paddingValues = paddingValues)
    }
}
