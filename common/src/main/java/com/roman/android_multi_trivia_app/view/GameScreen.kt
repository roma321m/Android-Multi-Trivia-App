package com.roman.android_multi_trivia_app.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.roman.android_multi_trivia_app.data.model.QuestionModel


@Composable
fun GameScreen(
    question: QuestionModel,
    score: Int,
    onOneClicked: () -> Unit,
    onTwoClicked: () -> Unit,
    onThreeClicked: () -> Unit,
    onFourClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 12.dp),
            text = "Score: $score"
        )

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f),
            painter = painterResource(id = question.icon),
            contentDescription = null
        )

        Spacer(modifier = Modifier.weight(0.1f))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(8.dp),
                onClick = {
                    onOneClicked()
                }
            ) {
                Text(text = question.answerOne)
            }
            Button(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(8.dp),
                onClick = {
                    onTwoClicked()
                }
            ) {
                Text(text = question.answerTwo)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(8.dp),
                onClick = {
                    onThreeClicked()
                }
            ) {
                Text(text = question.answerThree)
            }
            Button(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(8.dp),
                onClick = {
                    onFourClicked()
                }
            ) {
                Text(text = question.answerFour)
            }
        }
        Spacer(modifier = Modifier.weight(0.1f))
    }
}
