package com.roman.android_multi_trivia_app.view_model

sealed class CommonMainEvent {
    object AnswerOne : CommonMainEvent()
    object AnswerTwo : CommonMainEvent()
    object AnswerThree : CommonMainEvent()
    object AnswerFour : CommonMainEvent()
    object NewGame : CommonMainEvent()
}