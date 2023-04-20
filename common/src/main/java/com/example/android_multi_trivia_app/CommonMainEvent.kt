package com.example.android_multi_trivia_app

sealed class CommonMainEvent {
    object AnswerOneClicked : CommonMainEvent()
    object AnswerTwoClicked : CommonMainEvent()
    object AnswerThreeClicked : CommonMainEvent()
    object AnswerFourClicked : CommonMainEvent()
}