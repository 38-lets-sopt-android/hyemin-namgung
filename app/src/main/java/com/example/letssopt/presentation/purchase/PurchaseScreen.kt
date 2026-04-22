package com.example.letssopt.presentation.purchase

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.letssopt.common.navigation.MainTabRoute
import kotlinx.serialization.Serializable

@Serializable
data object Purchase : MainTabRoute

@Composable
fun PurchaseScreen(innerPadding: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = innerPadding),
        contentAlignment = Alignment.Center
    ) {
        Text("Purchase Screen")
    }
}
