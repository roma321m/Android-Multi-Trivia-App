package com.roman.android_multi_trivia_app.domain.fake_impl

import com.roman.android_multi_trivia_app.data.model.AnswerModel
import com.roman.android_multi_trivia_app.domain.DataProvider

class FakeDataProvider : DataProvider {
    override fun provide(): List<AnswerModel> {
        return emptyList()
    }
}