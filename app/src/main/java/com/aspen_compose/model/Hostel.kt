package com.aspen_compose.model

import androidx.annotation.DrawableRes

data class Hostel(
    val id: Int,
    @DrawableRes val image: Int,
    val name: String,
    val rate: String,
    val reviews: String,
    val description: String,
    val price: String,
    val facilities: List<String>
)