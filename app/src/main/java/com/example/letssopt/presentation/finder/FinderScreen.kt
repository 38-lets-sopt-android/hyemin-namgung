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
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.home.HomeFakeData
import com.example.letssopt.presentation.home.model.ContentItemModel
import com.example.letssopt.presentation.finder.component.WishlistSection

@Composable
fun FinderRoute(
    paddingValues: PaddingValues,
    viewModel: FinderViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    FinderScreen(
        uiState = uiState,
        innerPadding = paddingValues,
        onContentClick = {},
        onDeleteClick = viewModel::deleteWishlistItem
    )
}

@Composable
private fun FinderScreen(
    uiState: FinderUiState,
    innerPadding: PaddingValues,
    onContentClick: (ContentItemModel) -> Unit,
    onDeleteClick: (ContentItemModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(Modifier.weight(70f))

        WishlistSection(
            items = uiState.wishlistItems,
            onContentClick = onContentClick,
            onDeleteClick = onDeleteClick,
            modifier = Modifier.padding(innerPadding)
        )

        Spacer(Modifier.weight(193f))
    }
}

@Preview
@Composable
private fun FinderScreenPreview() {
    LETSSOPTTheme {
        FinderScreen(
            uiState = FinderUiState(
                wishlistItems = HomeFakeData.upcomingContentData
            ),
            innerPadding = PaddingValues(),
            onContentClick = {},
            onDeleteClick = {}
        )
    }
}
