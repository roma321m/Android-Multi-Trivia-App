package com.roman.football

import com.roman.android_multi_trivia_app.domain.DataProvider
import com.example.myapplication.R
import com.roman.android_multi_trivia_app.data.model.AnswerModel

object FootballDataProvider : DataProvider {

    override fun provide(): List<AnswerModel> {

        return listOf(
            AnswerModel("Barcelona", R.drawable.img_barcelona),
            AnswerModel("Chelsea", R.drawable.img_chelsea),
            AnswerModel("Arsenal", R.drawable.img_arsenal),
            AnswerModel("Liverpool", R.drawable.img_liverpool),
            AnswerModel("Real Madrid", R.drawable.img_real_madrid),
            AnswerModel("Tottenham", R.drawable.img_tottenham_hotspur),
            AnswerModel("Paris Saint Germain", R.drawable.img_paris_saint_germain),
            AnswerModel("Manchester United", R.drawable.img_manchester_united),
            AnswerModel("Atletico Madrid", R.drawable.img_atletico_de_madrid),
            AnswerModel("Borusia Dortmund", R.drawable.img_borusia_dortmund)
        )
    }

}