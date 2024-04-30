package com.example.jetpackcomposetutorial.navigationtutorial.nestednavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navigationjetpackcompose.nestednavigation.Screen

@Composable
fun ForgotScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Forgot Pass Screen", fontSize = 54.sp,color = Color.Black)
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            navController.navigate(Screen.ScreenLoginRoute.route)
        }) {
            Text(text = "Set pass(go login)")
        }

    }
    
}