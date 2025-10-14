package com.example.myapplication.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.components.GameHeader
import com.example.myapplication.ui.theme.enums.ScreenType

@Composable
fun MainMenu(){

}

@Composable
fun TicTacToeGame(){
    GameHeader(currentScreen = ScreenType.TICTACTOE, time = 0, score = 120)
    
    val game_map: Array<Array<Boolean?>> = arrayOf(
        arrayOf(null, true, null),
        arrayOf(null, null, null),
        arrayOf(null, null, null)
    )


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        val map_size = game_map.size - 1
        for (row in game_map) {
            Row() {
                for (item in row) {
                    Box() {
                        Button(
                            onClick = { /*TODO*/ },
                            shape = RectangleShape,
                            modifier = Modifier
                                .alpha(0.25f)
                                .size(96.dp)
                                .padding(8.dp)
                        ) {}
                        if (item != null) {
                            if (item) {
                                Image(
                                    painter = painterResource(id = R.drawable.tictactoe_selected),
                                    contentDescription = null,
                                    modifier = Modifier.size(96.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun GamblingGame(){

}