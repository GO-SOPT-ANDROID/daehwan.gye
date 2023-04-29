package org.android.go.sopt.external.home

import androidx.annotation.DrawableRes

data class HomeBodyData(
    val title: String,
    val creator: String,
    @DrawableRes val image: Int
) : HomeData