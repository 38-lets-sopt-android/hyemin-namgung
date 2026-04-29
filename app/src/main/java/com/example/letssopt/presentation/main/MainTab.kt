package com.example.letssopt.presentation.main

import androidx.annotation.DrawableRes
import com.example.letssopt.R
import com.example.letssopt.common.navigation.MainTabRoute
import com.example.letssopt.presentation.finder.Finder
import com.example.letssopt.presentation.home.Home
import com.example.letssopt.presentation.purchase.Purchase
import com.example.letssopt.presentation.search.Search
import com.example.letssopt.presentation.webtoon.Webtoon

enum class MainTab(
    @DrawableRes val iconRes: Int,
    val route: MainTabRoute,
    val label: String
) {
    HONE(
        iconRes = R.drawable.ic_logo,
        route = Home,
        label = "메인"
    ),

    PURCHASE(
        iconRes = R.drawable.ic_category,
        route = Purchase,
        label = "개별 구매"
    ),

    WEBTOON(
        iconRes = R.drawable.ic_wallet,
        route = Webtoon,
        label = "웹툰"
    ),

    SEARCH(
        iconRes = R.drawable.ic_search,
        route = Search,
        label = "찾기"
    ),

    FINDER(
        iconRes = R.drawable.ic_folder,
        route = Finder,
        label = "보관함"
    ) ;

}
