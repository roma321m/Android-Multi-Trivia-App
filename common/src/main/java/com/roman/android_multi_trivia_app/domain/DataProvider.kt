package com.roman.android_multi_trivia_app.domain

import com.roman.android_multi_trivia_app.data.model.AnswerModel

interface DataProvider {
    fun provide() : List<AnswerModel>
}
