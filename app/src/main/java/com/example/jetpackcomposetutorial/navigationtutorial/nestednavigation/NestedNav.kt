package com.example.navigationjetpackcompose.nestednavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetutorial.navigationtutorial.nestednavigation.appGraph
import com.example.jetpackcomposetutorial.navigationtutorial.nestednavigation.authGraph

@Composable
fun NestedNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.AuthRoute.route) {
        authGraph(navController)
        appGraph(navController)
    }
}