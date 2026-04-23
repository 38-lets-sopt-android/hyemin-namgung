package com.example.letssopt.presentation.finder

import androidx.lifecycle.ViewModel
import com.example.letssopt.presentation.home.HomeFakeData
import com.example.letssopt.presentation.home.model.ContentItemModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FinderViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        FinderUiState(
            wishlistitems = HomeFakeData.upcomingContentData
        )
    )

    val uiState: StateFlow<FinderUiState> = _uiState.asStateFlow()

    fun deleteWishlistItem(item: ContentItemModel) {
        _uiState.update { currentState ->
            currentState.copy(
                wishlistitems = currentState.wishlistitems
                    .filterNot { it.id == item.id }
                    .toImmutableList()
            )
        }
    }
}
