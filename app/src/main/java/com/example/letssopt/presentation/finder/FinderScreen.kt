package com.example.letssopt.presentation.finder

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.common.navigation.MainTabRoute
import com.example.letssopt.presentation.finder.component.WishlistSection
import kotlinx.serialization.Serializable

@Serializable
data object Finder : MainTabRoute

@Composable
fun FinderScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    viewModel: FinderViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(Modifier.weight(70f))

        WishlistSection(
            items = uiState.wishlistitems,
            onContentClick = {},
            onDeleteClick = viewModel::deleteWishlistItem,
            modifier = Modifier.padding(innerPadding)
        )

        Spacer(Modifier.weight(193f))
    }

}

@Preview
@Composable
private fun FinderScreenPreview() {
    FinderScreen(innerPadding = PaddingValues())
}
