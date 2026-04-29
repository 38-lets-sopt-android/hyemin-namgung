package com.example.letssopt.presentation.purchase

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PurchaseRoute(paddingValues: PaddingValues) {
    PurchaseScreen(
        innerPadding = paddingValues
    )
}

@Composable
private fun PurchaseScreen(innerPadding: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = innerPadding),
        contentAlignment = Alignment.Center
    ) {
        Text("Purchase Screen")
    }
}
