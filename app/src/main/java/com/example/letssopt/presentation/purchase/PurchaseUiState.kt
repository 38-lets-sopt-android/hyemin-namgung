package com.example.letssopt.presentation.purchase

import com.example.letssopt.presentation.home.HomeFakeData
import com.example.letssopt.presentation.home.model.ContentItemModel
import kotlinx.collections.immutable.ImmutableList

data class PurchaseUiState(
    val items: ImmutableList<ContentItemModel> = HomeFakeData.watgorithmData,
    val savedItemIds: Set<Long> = emptySet()
)
