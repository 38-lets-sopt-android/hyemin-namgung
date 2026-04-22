package com.example.letssopt.presentation.home

import com.example.letssopt.R
import com.example.letssopt.presentation.home.model.ContentItemModel
import com.example.letssopt.presentation.home.model.WatchaPartyModel
import kotlinx.collections.immutable.persistentListOf

object HomeFakeData {
    val newContentsData = persistentListOf(
        ContentItemModel(
            id = 1L,
            title = "매니페스트",
            imageRes = R.drawable.img_manifest
        ),
        ContentItemModel(
            id = 2L,
            title = "크라임씬 리턴즈",
            imageRes = R.drawable.img_crimescene
        ),
        ContentItemModel(
            id = 3L,
            title = "폭삭 속았수다",
            imageRes = R.drawable.img_poksak_sokassuda
        )
    )

    val watgorithmData = persistentListOf(
        ContentItemModel(
            id = 4L,
            title = "이 사랑 통역? 되나요",
            imageRes = R.drawable.img_love_translation
        ),
        ContentItemModel(
            id = 5L,
            title = "스트레인저 5",
            imageRes = R.drawable.img_stranger_things_5
        ),
        ContentItemModel(
            id = 6L,
            title = "프로젝트 헤일메리",
            imageRes = R.drawable.img_projecthailmary
        ),
    )

    val upcomingContentData = persistentListOf(
        ContentItemModel(
            id = 7L,
            title = "이 사랑 통역? 되나요",
            imageRes = R.drawable.img_love_translation
        ),
        ContentItemModel(
            id = 8L,
            title = "스트레인저 5",
            imageRes = R.drawable.img_stranger_things_5
        ),
        ContentItemModel(
            id = 9L,
            title = "프로젝트 헤일메리",
            imageRes = R.drawable.img_projecthailmary
        ),
    )
    val watchPartyData = persistentListOf(
        WatchaPartyModel(
            id = 10L,
            title = "왕과사는 남자",
            startTime = "21:13",
            imageRes = R.drawable.img_king_and_man
        ),
        WatchaPartyModel(
            id = 10L,
            title = "파묘",
            startTime = "22:22",
            imageRes = R.drawable.img_exhuma
        ),

    )
}
