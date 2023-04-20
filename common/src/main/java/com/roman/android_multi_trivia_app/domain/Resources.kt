package com.roman.android_multi_trivia_app.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface Resources {
    @get:StringRes
    val title: Int

    @get:DrawableRes
    val icon: Int
}