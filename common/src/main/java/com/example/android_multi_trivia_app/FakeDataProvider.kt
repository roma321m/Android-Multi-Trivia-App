package com.example.android_multi_trivia_app

class FakeDataProvider: DataProvider {
    override fun provide(): List<QuestionModel> {
        return listOf(
            QuestionModel(
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                R.drawable.ic_launcher_foreground
            )
        )
    }
}