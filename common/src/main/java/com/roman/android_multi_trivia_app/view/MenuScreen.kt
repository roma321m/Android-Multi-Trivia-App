package com.roman.android_multi_trivia_app.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.android_multi_trivia_app.R

@Composable
fun MenuScreen(
    @DrawableRes icon: Int,
    score: Int,
    onStartNewGameClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp),
            painter = painterResource(id = icon),
            contentDescription = null
        )

        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.last_score))
            Text(text = " $score")
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier
                .padding(8.dp),
            onClick = {
                onStartNewGameClicked()
            }
        ) {
            Text(text = stringResource(R.string.start_new_game))
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}