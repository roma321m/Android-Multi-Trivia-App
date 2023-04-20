package com.example.android_multi_trivia_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CommonMainScreen(
    resources: Resources,
    viewModel: CommonMainViewModel
) {
    Image(
        modifier = Modifier
            .fillMaxSize(),
        painter = painterResource(id = resources.background),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.1f))

        Text(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                )
                .weight(0.2f),
            text = stringResource(id = resources.title),
            style = MaterialTheme.typography.headlineSmall
        )

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f),
            painter = painterResource(id = viewModel.currentQuestionModel.icon),
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
                    viewModel.handle(CommonMainEvent.AnswerOneClicked)
                }
            ) {
                Text(text = viewModel.currentQuestionModel.answerOne)
            }
            Button(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(8.dp),
                onClick = {
                    viewModel.handle(CommonMainEvent.AnswerTwoClicked)
                }
            ) {
                Text(text = viewModel.currentQuestionModel.answerTwo)
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
                    viewModel.handle(CommonMainEvent.AnswerThreeClicked)
                }
            ) {
                Text(text = viewModel.currentQuestionModel.answerThree)
            }
            Button(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(8.dp),
                onClick = {
                    viewModel.handle(CommonMainEvent.AnswerFourClicked)
                }
            ) {
                Text(text = viewModel.currentQuestionModel.answerFour)
            }
        }
        Spacer(modifier = Modifier.weight(0.1f))
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CommonMainScreenPreview() {
    CommonMainScreen(
        resources = FakeResources(),
        viewModel = CommonMainViewModel(FakeDataProvider())
    )
}