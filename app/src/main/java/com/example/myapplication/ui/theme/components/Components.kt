package com.example.myapplication.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.enums.ScreenType

@Composable
fun GameHeader(currentScreen: MutableState<ScreenType>, time: Int, score: Int, modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)
    ){
        Row (verticalAlignment = Alignment.CenterVertically){
            ButtonChangeScreen(
                currentScreen,
                ScreenType.TICTACTOE,
                R.drawable.cross
            )
            Spacer(modifier = modifier.width(8.dp))
            ButtonChangeScreen(
                currentScreen,
                ScreenType.GAMBLING,
                R.drawable.euro
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
fun ButtonChangeScreen(screen: MutableState<ScreenType>, target_screen: ScreenType, ico: Int, modifier: Modifier = Modifier){
    val selected: Boolean = screen.value == target_screen
    val buttonSize = if (selected) 54.dp else 48.dp
    Box( contentAlignment = Alignment.Center) {
        Button(
            onClick = { if (!selected) screen.value = target_screen },
            modifier = modifier
                .alpha(0.6f)
                .size(buttonSize)

        ) {}
        Icon(
            painter = 
                painterResource(id = ico),
            contentDescription = null,
            modifier = modifier
                .size(32.dp)
                .alpha(0.75f)
        )
    }
}