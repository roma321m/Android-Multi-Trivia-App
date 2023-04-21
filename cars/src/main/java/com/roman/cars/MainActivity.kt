package com.roman.cars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.roman.android_multi_trivia_app.data.repository.LastScoreRepository
import com.roman.android_multi_trivia_app.view.CommonMainScreen
import com.roman.android_multi_trivia_app.view_model.CommonMainViewModel
import com.roman.cars.ui.theme.CarsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CarsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    CommonMainScreen(
                        resources = CarsResources(),
                        viewModel = CommonMainViewModel(
                            dataProvider = CarsDataProvider,
                            lastScoreRepository = LastScoreRepository(context)
                        )
                    )
                }
            }
        }
    }
}