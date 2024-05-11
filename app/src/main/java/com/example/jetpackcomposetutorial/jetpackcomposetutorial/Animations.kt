package com.example.jetpackcomposetutorial.jetpackcomposetutorial

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimationsSeries(modifier: Modifier = Modifier) {
    //AnimationVisible()
    //AnimationsAsFloat()
    //AnimationColor()
    //AnimationSize()
    AnimatedSizeE()
}

@Composable
fun AnimatedSizeE() {
    val colorGreen = Color(0XFF6BE185)
    val toggled by remember { mutableStateOf(false) }

    val animatedPadding by animateDpAsState(
        targetValue = if(toggled) 32.dp else 0.dp,
        label= "padding")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.aspectRatio(1f).fillMaxSize().padding(animatedPadding).background(colorGreen).clickable { toggled != toggled} )

    }

}

@Composable
fun AnimationSize() {
    val colorBlue = Color(0XFF4ABFF3)
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .animateContentSize()
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .height(if (expanded) 400.dp else 200.dp)
                .background(colorBlue)
                .clickable { expanded != expanded })

    }
}

@Composable
fun AnimationColor() {
    val colorBlue = Color(0XFF4ABFF3)
    val colorGreen = Color(0XFF6BE185)

    var changeColor by remember { mutableStateOf(false) }
    val animatedColor by animateColorAsState(
        targetValue = if (changeColor) colorGreen else colorBlue
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier
            .size(220.dp)
            .drawBehind { drawRect(animatedColor) })
        Spacer(modifier = Modifier.size(22.dp))
        Button(onClick = { changeColor != changeColor }) {
            Text(text = "Change Color", fontSize = 22.sp)

        }
    }

}

@Composable
fun AnimationsAsFloat() {
    var visible by remember { mutableStateOf(true) }
    val animationAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        label = "alpha"
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier
            .size(220.dp)
            .graphicsLayer {
                alpha = animationAlpha
            }
            .background(Color(0xFF4A8FF3))
        )
        Spacer(modifier = Modifier.size(22.dp))
        Button(onClick = { visible != visible }) {
            Text(text = if (visible) "Hide" else "Show", fontSize = 22.sp)

        }
    }
}

@Composable
fun AnimationVisible(modifier: Modifier = Modifier) {

    var visible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = scaleIn(),
            exit = scaleOut()
        ) {
            Box(
                modifier = Modifier
                    .size(220.dp)
                    .background(Color(0xFF4A8FF3))
            )
        }
        Spacer(modifier = Modifier.size(22.dp))
        Button(onClick = { visible = !visible }) {
            Text(text = if (visible) "Hide" else "Show", fontSize = 22.sp)

        }
    }
}