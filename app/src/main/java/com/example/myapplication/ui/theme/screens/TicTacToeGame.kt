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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.components.GameHeader
import com.example.myapplication.ui.theme.enums.ScreenType
import com.example.myapplication.ui.theme.enums.TicTacToeState
import androidx.compose.runtime.MutableState



@Composable
fun TicTacToeGame(screen: MutableState<ScreenType>,score: MutableState<Int>, time: Int, modifier: Modifier = Modifier){
    GameHeader(currentScreen = screen, time = time, score = score.value)
    
    val game_map: SnapshotStateList<SnapshotStateList<Boolean?>> =
    remember { GetEmptyBoard() }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        val map_size = game_map.size - 1
        for (i in 0..map_size) {
            val row_size = game_map[i].size - 1
            Row() {
                for (j in 0..row_size) {
                    Box( contentAlignment = Alignment.Center) {
                        Button(
                            onClick = {
                                if(game_map[i][j] == null) {
                                    //Player Turn
                                    game_map[i][j] = true
                                    var game_state: TicTacToeState = CheckMapFull(game_map)
                                    if(game_state != TicTacToeState.CONTINUE){
                                        if(game_state == TicTacToeState.CROSS){
                                            score.value += 10
                                        }
                                        game_map.clear()
                                        game_map.addAll(GetEmptyBoard())
                                    }

                                    //Circle Turn
                                    var circle_turn= true
                                    while(circle_turn){
                                        val row = (0..map_size).random()
                                        val column = (0..row_size).random()
                                        if(game_map[row][column] == null){
                                            game_map[row][column] = false
                                            circle_turn = false
                                        }
                                    }
                                    game_state = CheckMapFull(game_map)
                                    if(game_state != TicTacToeState.CONTINUE){
                                        if(game_state == TicTacToeState.CROSS){
                                            score.value += 10
                                        }
                                        game_map.clear()
                                        game_map.addAll(GetEmptyBoard())
                                    }
                                }
                            },
                            shape = RectangleShape,
                            modifier = modifier
                                .alpha(0.25f)
                                .size(96.dp)
                                .padding(8.dp)
                        ) {}
                        val cross: Boolean? = game_map[i][j]
                        Image(
                        painter =
                            if (cross == true)
                            painterResource(id = R.drawable.cross)
                            else
                            painterResource(id = R.drawable.circle),
                        contentDescription = null,
                        modifier = modifier
                            .size(64.dp)
                            .alpha(
                                if(cross == null) 0f
                                else 1f
                            )
                    )
                    }
                }
            }
        }
    }

}

fun GetEmptyBoard(): SnapshotStateList<SnapshotStateList<Boolean?>>{
    return mutableStateListOf(
        mutableStateListOf(null, null, null),
        mutableStateListOf(null, null, null),
        mutableStateListOf(null, null, null)
    )
}

fun CheckMapFull(list: List<List<Boolean?>>): TicTacToeState{
    var map_full = TicTacToeState.FULL
    var row_win: Boolean? = null
    var col_win: Boolean? = null
    var rdia_win: Boolean? = null
    var ldia_win: Boolean? = null


    val list_size = list.size - 1
    for(i in 0..list_size){
        val row_size = list[i].size - 1
        for(j in 0..row_size){
            if(list[i][j] == null){
                map_full = TicTacToeState.CONTINUE
            }
            else{
                var temp: Boolean?
                //Row Win Check
                if(j + 3 <= list[i].size) {
                    temp = list[i][j]
                    for (x in 1..2) {
                        if (list[i][j + x] != temp) {
                            temp = null
                        }
                    }
                    if(row_win == null){
                        row_win = temp
                    }
                }
                //Column Win Check
                if(i + 3 <= list.size){
                    temp = list[i][j]
                    for (x in 1..2) {
                        if (list[i + x][j] != temp) {
                            temp = null
                        }
                    }
                    if(col_win == null){
                        col_win = temp
                    }
                }
                //Right Diagonal Win Check
                if(i + 2 <= list_size && j + 2 <= row_size){
                    temp = list[i][j]
                    for (x in 1..2) {
                        if (list[i + x][j + x] != temp) {
                            temp = null
                        }
                    }
                    if(rdia_win == null){
                        rdia_win = temp
                    }
                }
                //Left Diagonal Win Check
                if(i - 2 >= 0 && j - 2 >= 0){
                    temp = list[i][j]
                    for (x in 1..2) {
                        if (list[i - x][j - x] != temp) {
                            temp = null
                        }
                    }
                    if(ldia_win == null){
                        ldia_win = temp
                    }
                }
            }
        }
    }
    if(row_win == true || col_win == true || rdia_win == true || ldia_win == true){
        map_full = TicTacToeState.CROSS
    }
    else if (row_win == false || col_win == false || rdia_win == false || ldia_win == false){
        map_full = TicTacToeState.CIRCLE
    }

    return map_full
}

