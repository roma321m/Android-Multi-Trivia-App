package com.example.android_multi_trivia_app

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface Resources {
    @get:StringRes
    val title: Int

    @get:DrawableRes
    val background: Int
}