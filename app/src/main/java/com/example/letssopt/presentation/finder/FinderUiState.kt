package com.example.letssopt.presentation.finder

import com.example.letssopt.presentation.home.model.ContentItemModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class FinderUiState(
    val wishlistItems : ImmutableList<ContentItemModel> = persistentListOf(),
    val isLoading: Boolean = true
)
