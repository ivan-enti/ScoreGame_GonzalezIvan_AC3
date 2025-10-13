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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.myapplication.ui.theme.components.GameHeader
import com.example.myapplication.ui.theme.enums.ScreenType

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

    Box( modifier = modifier.fillMaxSize()) {
        GameHeader(ScreenType.TICTACTOE, 60, 1520)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme() {
        GameApp()
    }
}