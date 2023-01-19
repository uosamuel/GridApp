package com.example.gridapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val StringResource: Int,
    val numberOfCourse: Int,
    @DrawableRes val ImageResource: Int,
)
