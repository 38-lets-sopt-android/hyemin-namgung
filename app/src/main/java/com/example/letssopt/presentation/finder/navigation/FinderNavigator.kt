package com.example.letssopt.presentation.finder.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.common.navigation.MainTabRoute
import com.example.letssopt.presentation.finder.FinderRoute
import kotlinx.serialization.Serializable

@Serializable
data object Finder : MainTabRoute

fun NavController.navigateToFinder() {
    navigate(
        route = Finder,
    )
}

fun NavGraphBuilder.finderNavGraph(
    paddingValues: PaddingValues
) {
    composable<Finder> {
        FinderRoute(
            paddingValues = paddingValues
        )
    }
}
