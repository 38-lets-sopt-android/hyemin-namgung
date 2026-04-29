package com.example.letssopt.presentation.finder.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography
import com.example.letssopt.presentation.home.HomeFakeData
import com.example.letssopt.presentation.home.model.ContentItemModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun WishlistSection(
    items: ImmutableList<ContentItemModel>,
    onContentClick: (ContentItemModel) -> Unit,
    onDeleteClick: (ContentItemModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    val horizontalPadding = 16.dp

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "찜한 목록",
            modifier = Modifier
                .padding(start = horizontalPadding, top = 24.dp, bottom = 24.dp),
            style = typography.h3,
            color = LETSSOPTColors.TextPrimary
        )

        if (items.isEmpty()) {
            EmptyWishlist(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    bottom = 24.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(
                    items = items,
                    key = { it.id }
                ) { item ->
                    WishlistPosterCard(
                        item = item,
                        onContentClick = { onContentClick(item) },
                        onDeleteClick = { onDeleteClick(item) }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun WishlistSectionPreview() {
    WishlistSection(
        items = HomeFakeData.upcomingContentData,
        onContentClick = {},
        onDeleteClick = {}
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun EmptyWishlistSectionPreview() {
    LETSSOPTTheme {
        WishlistSection(
            items = persistentListOf(),
            onContentClick = {},
            onDeleteClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
