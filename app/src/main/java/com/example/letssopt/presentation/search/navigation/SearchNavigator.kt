package com.example.letssopt.presentation.search.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.common.navigation.MainTabRoute
import com.example.letssopt.presentation.search.SearchRoute
import kotlinx.serialization.Serializable

@Serializable
data object Search : MainTabRoute

fun NavController.navigateToSearch(){
    navigate(
        route = Search
    )
}

fun NavGraphBuilder.searchNavGraph(paddingValues: PaddingValues){
    composable<Search> {
        SearchRoute(
            paddingValues = paddingValues
        )
    }
}
