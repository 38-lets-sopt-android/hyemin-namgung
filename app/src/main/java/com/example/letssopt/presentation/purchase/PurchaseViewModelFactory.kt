package com.example.letssopt.presentation.purchase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.letssopt.local.purchase.dao.PurchaseDao

class PurchaseViewModelFactory(
    private val purchaseDao: PurchaseDao
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PurchaseViewModel::class.java)) {
            return PurchaseViewModel(purchaseDao) as T
        }

        throw IllegalArgumentException("PurchaseViewModel Class is Not Found")
    }
}
