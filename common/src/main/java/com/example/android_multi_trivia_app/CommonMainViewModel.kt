package com.example.android_multi_trivia_app

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CommonMainViewModel(
    dataProvider: DataProvider
) : ViewModel() {

    companion object {
        const val TAG = "CommonMainViewModel"
    }

    private val questionList = dataProvider.provide()

    private var index = 0
    var currentQuestionModel by mutableStateOf(
        questionList[index]
    )
        private set

    var score by mutableStateOf(0)
        private set

    var gameFinished by mutableStateOf(false)
        private set

    fun handle(event: CommonMainEvent) {
        when (event) {
            CommonMainEvent.AnswerFourClicked -> checkAnswer(currentQuestionModel.answerOne)
            CommonMainEvent.AnswerOneClicked -> checkAnswer(currentQuestionModel.answerTwo)
            CommonMainEvent.AnswerThreeClicked -> checkAnswer(currentQuestionModel.answerThree)
            CommonMainEvent.AnswerTwoClicked -> checkAnswer(currentQuestionModel.answerFour)
        }
    }

    private fun checkAnswer(answer: String) {
        Log.d(TAG, "Checking answer")
        if (answer == currentQuestionModel.answerFive) {
            score++
        }
        moveToNextQ()
    }

    private fun moveToNextQ() {
        if (index == questionList.size - 1) {
            Log.d(TAG, "Finish game")
            gameFinished = true
        } else {
            Log.d(TAG, "Move to next question")
            index++
            currentQuestionModel = questionList[index]
        }
    }
}