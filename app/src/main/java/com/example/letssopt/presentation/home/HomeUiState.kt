package com.example.letssopt.presentation.home

import com.example.letssopt.presentation.home.model.ContentItemModel
import com.example.letssopt.presentation.home.model.WatchaPartyModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class HomeUiState (
    val wishlistItems : ImmutableList<ContentItemModel> = persistentListOf(),

    val newContentItems :  ImmutableList<ContentItemModel> =  HomeFakeData.newContentsData,

    val watgorithmItems : ImmutableList<ContentItemModel> = HomeFakeData.watgorithmData,

    val upcomingItems : ImmutableList<ContentItemModel> = HomeFakeData.upcomingContentData,

    val watchaPartyItems : ImmutableList<WatchaPartyModel> = HomeFakeData.watchaPartyData

)
