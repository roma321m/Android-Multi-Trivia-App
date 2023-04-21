package com.roman.cars

import com.roman.android_multi_trivia_app.domain.DataProvider
import com.roman.android_multi_trivia_app.data.model.AnswerModel

object CarsDataProvider : DataProvider {

    override fun provide(): List<AnswerModel> {

        return listOf(
            AnswerModel("Rolls Royce", R.drawable.img_rolls_royce),
            AnswerModel("Audi", R.drawable.img_audi),
            AnswerModel("Tesla", R.drawable.img_tesla),
            AnswerModel("BMW", R.drawable.img_bmd),
            AnswerModel("Ferrari", R.drawable.img_ferrari),
            AnswerModel("Ford", R.drawable.img_ford),
            AnswerModel("Lamborghini", R.drawable.img_lamborghini),
            AnswerModel("Mazda", R.drawable.img_mazda),
            AnswerModel("Mercedes Benz", R.drawable.img_mercedes_benz),
            AnswerModel("Nissan", R.drawable.img_nissan),
            AnswerModel("Porsche", R.drawable.img_porsche),
            AnswerModel("Skoda", R.drawable.img_skoda),
        )
    }

}