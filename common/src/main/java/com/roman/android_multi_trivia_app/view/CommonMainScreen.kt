package com.roman.android_multi_trivia_app.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roman.android_multi_trivia_app.view_model.CommonMainEvent
import com.roman.android_multi_trivia_app.view_model.CommonMainViewModel
import com.roman.android_multi_trivia_app.domain.fake_impl.FakeDataProvider
import com.roman.android_multi_trivia_app.domain.fake_impl.FakeResources
import com.roman.android_multi_trivia_app.data.model.RequestState
import com.roman.android_multi_trivia_app.data.repository.LastScoreRepository
import com.roman.android_multi_trivia_app.domain.Resources


@Composable
fun CommonMainScreen(
    resources: Resources,
    viewModel: CommonMainViewModel
) {
    val lastScore = viewModel.lastScore.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 30.dp,
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 30.dp
                ),
            text = stringResource(id = resources.title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall
        )
        if (viewModel.isMenu) {
            MenuScreen(
                icon = resources.icon,
                score = if (lastScore is RequestState.Success) {
                    lastScore.data
                } else {
                    viewModel.score
                },
                onStartNewGameClicked = {
                    viewModel.handle(CommonMainEvent.NewGame)
                }
            )
        } else {
            GameScreen(
                question = viewModel.currentQuestionModel,
                score = viewModel.score,
                onOneClicked = {
                    viewModel.handle(CommonMainEvent.AnswerOne)
                },
                onTwoClicked = {
                    viewModel.handle(CommonMainEvent.AnswerTwo)
                },
                onThreeClicked = {
                    viewModel.handle(CommonMainEvent.AnswerThree)
                },
                onFourClicked = {
                    viewModel.handle(CommonMainEvent.AnswerFour)
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommonMainScreenPreview() {
    val context = LocalContext.current
    CommonMainScreen(
        resources = FakeResources(),
        viewModel = CommonMainViewModel(
            dataProvider = FakeDataProvider(),
            lastScoreRepository = LastScoreRepository(context)
        )
    )
}