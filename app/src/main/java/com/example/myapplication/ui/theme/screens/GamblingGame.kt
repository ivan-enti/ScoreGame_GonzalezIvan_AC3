package com.example.myapplication.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.components.GameHeader
import com.example.myapplication.ui.theme.enums.ScreenType
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamblingGame(screen: MutableState<ScreenType>, score: MutableState<Int>, time: Int, modifier: Modifier = Modifier){
    GameHeader(currentScreen = screen, time = time, score = score.value)

    val bet_txt = remember { mutableStateOf("")}
    val bet = remember { mutableStateOf(0)}
    val bet_multi = remember { mutableStateOf(2f)}
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Row(){
            Text(
                text = bet.value.toString(),
                fontSize = 64.sp
            )
            if(bet_multi.value > 2) {
                Text(
                    text = "x" + bet_multi.value.toString(),
                    fontSize = 32.sp
                )
            }
        }
        TextField(
            value = bet_txt.value,
            onValueChange = {newTxt -> bet_txt.value = newTxt},
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 32.sp
            )
        )
        Row(){
            Box( contentAlignment = Alignment.Center) {
                Button(
                    onClick = {
                        val current_bet: Int? = bet_txt.value.toIntOrNull()
                        if(current_bet != null){
                            if(current_bet <= score.value) {
                                val rand = (0..1).random()
                                if (rand == 0) {
                                    val tmp = current_bet * bet_multi.value
                                    score.value -= current_bet
                                    bet.value += tmp.roundToInt()
                                    bet_multi.value += 0.25f
                                } else {
                                    score.value -= current_bet
                                    bet.value = 0
                                    bet_multi.value = 0f
                                }
                            }
                        }
                        bet_txt.value = ""
                    },
                    shape = RectangleShape,
                    modifier = modifier
                        .size(124.dp, 80.dp)
                        .padding(16.dp)
                ) {}
                Text(
                    text = "+",
                    fontSize = 32.sp,
                    color = Color.White
                )
            }
            Box( contentAlignment = Alignment.Center) {
                Button(
                    onClick = {
                        score.value += bet.value
                        bet.value = 0
                        bet_multi.value = 0f
                    },
                    shape = RectangleShape,
                    modifier = modifier
                        .size(124.dp, 80.dp)
                        .padding(16.dp)
                ) {}
                Text(
                    text = "-",
                    fontSize = 24.sp,
                    color = Color.White
                )
            }
        }
    }
}