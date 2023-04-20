package com.example.android_multi_trivia_app

import androidx.annotation.DrawableRes

data class QuestionModel(
    val answerOne : String,
    val answerTwo : String,
    val answerThree : String,
    val answerFour : String,
    val answerFive : String,
    @DrawableRes val icon: Int
)