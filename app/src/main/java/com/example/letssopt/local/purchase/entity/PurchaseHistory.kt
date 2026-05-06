package com.example.letssopt.local.purchase.entity

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purchase_history")
data class PurchaseHistory(
    @PrimaryKey
    @ColumnInfo(name = "content_id")
    val contentId : Long,

    @ColumnInfo(name = "title")
    val title : String,

    @DrawableRes
    @ColumnInfo(name = "img_res")
    val imageRes : Int
)
