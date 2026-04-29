package com.example.letssopt.presentation.home.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class ContentItemModel(
    val id: Long,
    val title: String,
    @DrawableRes val imageRes: Int
)
