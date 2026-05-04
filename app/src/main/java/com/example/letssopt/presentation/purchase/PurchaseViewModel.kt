package com.example.letssopt.presentation.purchase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.local.purchase.dao.PurchaseDao
import com.example.letssopt.local.purchase.entity.PurchaseHistory
import com.example.letssopt.presentation.home.model.ContentItemModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PurchaseViewModel(
    private val purchaseDao: PurchaseDao
) : ViewModel() {
    private val _uiState = MutableStateFlow(PurchaseUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            purchaseDao.getAllPurchaseList().collect { purchaseList ->
                _uiState.value = _uiState.value.copy(
                    savedItemIds = purchaseList.map(PurchaseHistory::contentId).toSet()
                )
            }
        }
    }

    fun savePurchaseItem(item: ContentItemModel) {
        if (_uiState.value.savedItemIds.contains(item.id)) return

        viewModelScope.launch {
            purchaseDao.insert(item.toPurchaseHistory())
        }
    }
}

private fun ContentItemModel.toPurchaseHistory(): PurchaseHistory =
    PurchaseHistory(
        contentId = id,
        title = title,
        imageRes = imageRes
    )
