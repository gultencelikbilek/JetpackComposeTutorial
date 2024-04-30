package com.example.jetpackcomposetutorial.navigationtutorial.navwithargument


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(navContorller: NavHostController) {

    var nameValue by remember{
        mutableStateOf("")
    }
    var ageValue by remember{
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Screen", fontSize = 54.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(65.dp))
        TextField(
            value = nameValue,
            onValueChange = { nameValue = it },
            modifier = Modifier.padding(10.dp),
            placeholder = {
                Text(text = "Enter your name")
            }
        )
        TextField(
            value = ageValue,
            onValueChange ={
                ageValue = it
            } ,
            modifier = Modifier.padding(10.dp),
            placeholder = {
                Text(text = "Enter your age")
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            // navContorller.navigate("details_screen/$nameValue/$ageValue") //boş bıarkılırsa bu alanlar uygulama çöker
            navContorller.navigate("details_screen?name=$nameValue&age=$ageValue")//null olmasına izin verir
        }) {
            Text(text = "Pass data", fontSize = 30.sp, color = Color.White)
        }
    }
}