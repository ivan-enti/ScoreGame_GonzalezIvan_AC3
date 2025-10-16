package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.myapplication.ui.theme.enums.ScreenType
import com.example.myapplication.ui.theme.screens.GamblingGame
import com.example.myapplication.ui.theme.screens.MainMenu
import com.example.myapplication.ui.theme.screens.TicTacToeGame
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameApp()
                }
            }
        }
    }
}

@Composable
fun GameApp(modifier: Modifier = Modifier) {
    val currentScreen = remember { mutableStateOf(ScreenType.MAIN_MENU) }
    val score = remember { mutableStateOf(120) }
    val time = remember { mutableStateOf(0)}

    Box( modifier = modifier.fillMaxSize()) {
        when (currentScreen.value){
            ScreenType.MAIN_MENU -> MainMenu(currentScreen)
            ScreenType.TICTACTOE -> TicTacToeGame(currentScreen, score, time.value)
            ScreenType.GAMBLING -> GamblingGame(currentScreen, score, time.value)
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            if(currentScreen.value == ScreenType.MAIN_MENU) {
                delay(1000L)
                time.value++
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme() {
        GameApp()
    }
}

