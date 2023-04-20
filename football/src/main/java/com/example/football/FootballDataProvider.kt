package com.example.football

import com.example.android_multi_trivia_app.DataProvider
import com.example.android_multi_trivia_app.QuestionModel
import com.example.myapplication.R

object FootballDataProvider : DataProvider {

    override fun provide(): List<QuestionModel> {
        return listOf(
            QuestionModel(
                "Barcelona",
                "Chelsea",
                "Arsenal",
                "Liverpool",
                "Arsenal",
                R.drawable.img_arsenal
            ),
            QuestionModel(
                "Real Madrid",
                "Barcelona",
                "Tottenham",
                "Paris Saint Germain",
                "Barcelona",
                R.drawable.img_barcelona
            ),
            QuestionModel(
                "Manchester United",
                "Chelsea",
                "Liverpool",
                "Paris Saint Germain",
                "Paris Saint Germain",
                R.drawable.img_paris_saint_germain
            )
        )
    }

}
// Barcelona
// Chelsea
// Arsenal
// Liverpool
// Atletico Madrid
// Borusia Dortmund
// Manchester United
// Paris Saint Germain
// Real Madrid
// Tottenham