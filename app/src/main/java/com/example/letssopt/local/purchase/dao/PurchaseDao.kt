package com.example.letssopt.local.purchase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.letssopt.local.purchase.entity.PurchaseHistory
import kotlinx.coroutines.flow.Flow

@Dao
interface PurchaseDao{
    @Insert
    suspend fun insert(content: PurchaseHistory)

    @Query("SELECT *  FROM purchase_history")
    fun getAllPurchaseList() : Flow<List<PurchaseHistory>>

    @Delete
    suspend fun delete(purchaseHistory: PurchaseHistory)

    @Query("DELETE FROM purchase_history WHERE content_id = :contentId")
    suspend fun deleteByContentId(contentId: Long)
}
