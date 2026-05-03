package com.example.letssopt.presentation.finder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.local.purchase.dao.PurchaseDao
import com.example.letssopt.local.purchase.entity.PurchaseHistory
import com.example.letssopt.presentation.home.model.ContentItemModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FinderViewModel(
    private val purchaseDao: PurchaseDao
) : ViewModel() {
    private val _uiState = MutableStateFlow(FinderUiState())

    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            purchaseDao.getAllPurchaseList().collect { purchaseList ->
                _uiState.value = FinderUiState(
                    wishlistItems = purchaseList
                        .map(PurchaseHistory::toContentItemModel)
                        .toImmutableList()
                )
            }
        }
    }

    fun deleteWishlistItem(item: ContentItemModel) {
        viewModelScope.launch {
            purchaseDao.deleteByContentId(item.id)
        }
    }
}

private fun PurchaseHistory.toContentItemModel(): ContentItemModel =
    ContentItemModel(
        id = contentId,
        title = title,
        imageRes = imageRes
    )
