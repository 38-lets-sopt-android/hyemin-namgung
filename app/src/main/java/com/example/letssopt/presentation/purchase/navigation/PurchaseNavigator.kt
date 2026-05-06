package com.example.letssopt.presentation.purchase.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.common.navigation.MainTabRoute
import com.example.letssopt.presentation.purchase.PurchaseRoute
import kotlinx.serialization.Serializable

@Serializable
data object Purchase : MainTabRoute

fun NavController.navigateToPurchase(

){
    navigate(route = Purchase)
}

fun NavGraphBuilder.purchaseNavGraph(paddingValues: PaddingValues){
    composable<Purchase> {
        PurchaseRoute(paddingValues = paddingValues)
    }
}
