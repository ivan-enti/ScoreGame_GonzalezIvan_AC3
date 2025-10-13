package com.example.myapplication.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.enums.ScreenType

@Composable
fun GameHeader(currentScreen: ScreenType, time: Int, score: Int, modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)
    ){
        Row {
            ButtonChangeScreen(
                R.drawable.tictactoe_selected,
                R.drawable.tictactoe_unselected,
                currentScreen == ScreenType.TICTACTOE
            )
            ButtonChangeScreen(
                R.drawable.euro_selected,
                R.drawable.euro_unselected,
                currentScreen == ScreenType.GAMBLING
            )
        }
        Text(
            text = time.toString(),
            style = MaterialTheme.typography.bodySmall,
            fontSize = 32.sp
        )
        Text(
            text = score.toString(),
            style = MaterialTheme.typography.bodySmall,
            fontSize = 32.sp
        )
    }
}

@Composable
fun ButtonChangeScreen(selected_ico: Int, unselected_ico: Int, select: Boolean){
    Box( contentAlignment = Alignment.Center) {
        Button(
            onClick = { /*TODO*/ },
            colors =
                if (select) ButtonDefaults.buttonColors(containerColor = Color.White)
                else ButtonDefaults.buttonColors(),
            modifier = Modifier.size(48.dp)
        ) {}
        Icon(
            painter = 
                if (select) painterResource(id = selected_ico)
                else painterResource(id = unselected_ico),
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
    }
}