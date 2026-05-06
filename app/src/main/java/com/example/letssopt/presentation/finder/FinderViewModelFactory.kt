package com.example.letssopt.presentation.finder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.letssopt.local.purchase.dao.PurchaseDao

class FinderViewModelFactory(
    private val purchaseDao: PurchaseDao
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FinderViewModel::class.java)) {
            return FinderViewModel(purchaseDao) as T
        }

        throw IllegalArgumentException("FinderViewModel Class is Not Found")
    }
}
