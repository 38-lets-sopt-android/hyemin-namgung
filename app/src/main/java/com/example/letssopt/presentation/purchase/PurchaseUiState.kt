package com.example.letssopt.presentation.purchase

import com.example.letssopt.data.mock.AppMockData
import com.example.letssopt.presentation.home.model.ContentItemModel
import kotlinx.collections.immutable.ImmutableList

data class PurchaseUiState(
    val items: ImmutableList<ContentItemModel> = AppMockData.contentsData,
    val savedItemIds: Set<Long> = emptySet()
)
