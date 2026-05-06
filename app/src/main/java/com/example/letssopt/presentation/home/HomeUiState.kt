package com.example.letssopt.presentation.home

import com.example.letssopt.data.mock.AppMockData
import com.example.letssopt.presentation.home.model.ContentItemModel
import com.example.letssopt.presentation.home.model.WatchaPartyModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class HomeUiState (
    val wishlistItems : ImmutableList<ContentItemModel> = persistentListOf(),

    val newContentItems :  ImmutableList<ContentItemModel> =  AppMockData.newContentsData,

    val watgorithmItems : ImmutableList<ContentItemModel> = AppMockData.watgorithmData,

    val upcomingItems : ImmutableList<ContentItemModel> = AppMockData.upcomingContentData,

    val watchaPartyItems : ImmutableList<WatchaPartyModel> = AppMockData.watchaPartyData

)
