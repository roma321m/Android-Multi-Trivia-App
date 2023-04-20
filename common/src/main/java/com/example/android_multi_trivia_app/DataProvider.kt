package com.example.android_multi_trivia_app

interface DataProvider {
    fun provide() : List<QuestionModel>
}
