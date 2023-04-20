package com.roman.android_multi_trivia_app.logic

import com.example.android_multi_trivia_app.R
import com.roman.android_multi_trivia_app.data.model.AnswerModel
import com.roman.android_multi_trivia_app.data.model.QuestionModel
import kotlin.random.Random

object QuestionProvider {

    fun provide(answers: List<AnswerModel>): List<QuestionModel> {
        val options = answers.associate { answerModel ->
            Pair(answerModel.answer, answerModel.icon)
        }
        if (options.size < 4) {
            return fakeQuestions()
        }
        val questions = mutableListOf<QuestionModel>()

        options.forEach {
            val answersForOneQuestion = mutableSetOf(it.key)
            while (answersForOneQuestion.size != 4) {
                answersForOneQuestion.add(options.entries.elementAt(Random.nextInt(options.size)).key)
            }
            val shuffledAnswers = answersForOneQuestion.shuffled()
            questions.add(
                QuestionModel(
                    answerOne = shuffledAnswers.elementAt(0),
                    answerTwo = shuffledAnswers.elementAt(1),
                    answerThree = shuffledAnswers.elementAt(2),
                    answerFour = shuffledAnswers.elementAt(3),
                    answerFive = it.key,
                    icon = it.value
                )
            )
        }
        return questions.shuffled()
    }

    private fun fakeQuestions(): List<QuestionModel> {
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