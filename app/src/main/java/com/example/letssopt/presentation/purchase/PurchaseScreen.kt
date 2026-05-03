package com.example.letssopt.presentation.purchase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography
import com.example.letssopt.local.database.AppDatabase
import com.example.letssopt.presentation.home.HomeFakeData
import com.example.letssopt.presentation.home.model.ContentItemModel
import com.example.letssopt.presentation.purchase.component.PurchaseHistoryPosterCard

@Composable
fun PurchaseRoute(paddingValues: PaddingValues) {
    val context = LocalContext.current
    val purchaseDao = remember(context) {
        AppDatabase.getDatabase(context).purchaseDao()
    }
    val viewModel: PurchaseViewModel = viewModel(
        factory = PurchaseViewModelFactory(purchaseDao)
    )
    val uiState by viewModel.uiState.collectAsState()

    PurchaseScreen(
        innerPadding = paddingValues,
        uiState = uiState,
        onContentClick = {},
        onSaveClick = viewModel::savePurchaseItem
    )
}

@Composable
private fun PurchaseScreen(
    uiState: PurchaseUiState,
    innerPadding: PaddingValues,
    onContentClick: (ContentItemModel) -> Unit,
    onSaveClick: (ContentItemModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = "개별 구매",
        modifier = Modifier.padding(16.dp),
        color = LETSSOPTColors.TextPrimary,
        style = typography.h3
    )

    Spacer(modifier =Modifier.height(40.dp))

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues = innerPadding)
            .background(Color.Black),
        contentPadding = PaddingValues(vertical = 30.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {

        items(
            items = uiState.items,
            key = { item -> item.id }
        ) { item ->
            PurchaseHistoryPosterCard(
                title = item.title,
                imageRes = item.imageRes,
                isSaved = uiState.savedItemIds.contains(item.id),
                onPosterClick = { onContentClick(item) },
                onSaveClick = { onSaveClick(item) },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview
@Composable
private fun PurchaseScreenPreview() {
    LETSSOPTTheme {
        PurchaseScreen(
            uiState = PurchaseUiState(
                items = HomeFakeData.watgorithmData,
                savedItemIds = setOf(HomeFakeData.watgorithmData.first().id)
            ),
            innerPadding = PaddingValues(),
            onContentClick = {},
            onSaveClick = {}
        )
    }
}
