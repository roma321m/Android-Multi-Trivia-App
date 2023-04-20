package com.example.football

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.android_multi_trivia_app.CommonMainScreen
import com.example.android_multi_trivia_app.CommonMainViewModel
import com.example.football.ui.theme.FootballAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FootballAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CommonMainScreen(
                        resources = FootballResources(),
                        viewModel = CommonMainViewModel(
                            dataProvider = FootballDataProvider
                        )
                    )
                }
            }
        }
    }
}