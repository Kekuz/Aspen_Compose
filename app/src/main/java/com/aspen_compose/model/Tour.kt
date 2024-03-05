package com.aspen_compose.model

import androidx.annotation.DrawableRes

data class Tour(
    @DrawableRes val image: Int,
    val name: String,
    val interval: String,
    val isHot: Boolean,
)
