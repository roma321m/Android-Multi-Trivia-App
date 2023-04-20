package com.roman.android_multi_trivia_app.data.model

import androidx.annotation.DrawableRes

data class AnswerModel(
    val answer: String,
    @DrawableRes val icon: Int
)