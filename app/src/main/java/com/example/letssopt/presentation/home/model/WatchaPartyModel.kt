package com.example.letssopt.presentation.home.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class WatchaPartyModel(
    val id: Long,
    val title: String,
    val startTime : String,
    @DrawableRes val imageRes: Int
)
