package com.example.myapplication.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.enums.ScreenType

@Composable
fun MainMenu(screen: MutableState<ScreenType>, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "ScoreGame",
            fontSize = 48.sp
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = "485",
            fontSize = 48.sp
        )
        Spacer(modifier = modifier.height(32.dp))
        Button(
            onClick = { screen.value = ScreenType.TICTACTOE },
            shape = RectangleShape,
            modifier = modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {
            Text(
                text = "START",
                fontSize = 32.sp
            )
        }
    }
}