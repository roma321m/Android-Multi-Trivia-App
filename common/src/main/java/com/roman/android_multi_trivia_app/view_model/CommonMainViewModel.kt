package com.roman.android_multi_trivia_app.view_model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roman.android_multi_trivia_app.data.model.QuestionModel
import com.roman.android_multi_trivia_app.data.model.RequestState
import com.roman.android_multi_trivia_app.data.repository.LastScoreRepository
import com.roman.android_multi_trivia_app.domain.DataProvider
import com.roman.android_multi_trivia_app.logic.QuestionProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CommonMainViewModel(
    dataProvider: DataProvider,
    private val lastScoreRepository: LastScoreRepository,
    private val questionProvider: QuestionProvider = QuestionProvider
) : ViewModel() {

    companion object {
        const val TAG = "CommonMainViewModel"
    }

    private val _lastScore =
        MutableStateFlow<RequestState<Int>>(RequestState.Idle)
    val lastScore: StateFlow<RequestState<Int>> = _lastScore

    init {
        readLastScore()
    }

    private val answers = dataProvider.provide()
    private var questions: List<QuestionModel> = questionProvider.provide(answers)

    private var index = 0
    var currentQuestionModel by mutableStateOf(
        questions[index]
    )
        private set

    var score by mutableStateOf(0)
        private set

    var isMenu by mutableStateOf(true)
        private set

    fun handle(event: CommonMainEvent) {
        when (event) {
            CommonMainEvent.AnswerOne -> checkAnswer(currentQuestionModel.answerOne)
            CommonMainEvent.AnswerTwo -> checkAnswer(currentQuestionModel.answerTwo)
            CommonMainEvent.AnswerThree -> checkAnswer(currentQuestionModel.answerThree)
            CommonMainEvent.AnswerFour -> checkAnswer(currentQuestionModel.answerFour)
            CommonMainEvent.NewGame -> newGame()
        }
    }

    private fun persistLastScore() {
        Log.d(TAG, "persistLastScore")
        viewModelScope.launch(Dispatchers.IO) {
            lastScoreRepository.persistLastScore(score)
        }
    }

    private fun readLastScore() {
        Log.d(TAG, "readLastScore")
        _lastScore.value = RequestState.Loading
        try {
            viewModelScope.launch {
                lastScoreRepository.readLastScore
                    .map { it }
                    .collect { _lastScore.value = RequestState.Success(it) }
            }
        } catch (exception: Exception) {
            _lastScore.value = RequestState.Error(exception)
        }
    }

    private fun newGame() {
        questions = questionProvider.provide(answers)
        score = 0
        index = 0
        isMenu = false
    }

    private fun checkAnswer(answer: String) {
        Log.d(TAG, "Checking answer: clicked: ($answer), actual: (${currentQuestionModel.answerFive})")
        if (answer == currentQuestionModel.answerFive) {
            score++
        }
        moveToNextQ()
    }

    private fun moveToNextQ() {
        if (index == questions.size - 1) {
            Log.d(TAG, "Finish game")
            isMenu = true
            persistLastScore()
        } else {
            Log.d(TAG, "Move to next question")
            index++
            currentQuestionModel = questions[index]
        }
    }
}