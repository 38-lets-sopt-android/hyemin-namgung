package com.example.letssopt.presentation.webtoon.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.common.navigation.MainTabRoute
import com.example.letssopt.presentation.webtoon.WebtoonRoute
import kotlinx.serialization.Serializable

@Serializable
data object Webtoon : MainTabRoute

fun NavController.navigateToWebtoon(){
    navigate(route = Webtoon)
}

fun NavGraphBuilder.webtoonNavGraph(paddingValues: PaddingValues){
    composable<Webtoon> {
        WebtoonRoute(paddingValues = paddingValues)
    }
}
