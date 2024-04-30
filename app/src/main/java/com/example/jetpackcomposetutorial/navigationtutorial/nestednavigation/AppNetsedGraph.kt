package com.example.jetpackcomposetutorial.navigationtutorial.nestednavigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.navigationjetpackcompose.nestednavigation.HomeScreen
import com.example.navigationjetpackcompose.nestednavigation.Screen
import com.example.navigationjetpackcompose.nestednavigation.ScreenA
import com.example.navigationjetpackcompose.nestednavigation.ScreenB

fun NavGraphBuilder.appGraph(navController: NavHostController) {

    navigation(startDestination = Screen.ScreenHomeRoute.route, route = Screen.AppRoute.route) {
        composable(Screen.ScreenHomeRoute.route) {
            HomeScreen(navController)
        }
        composable(Screen.ScreenARoute.route) {
            ScreenA(navController)
        }
        composable(Screen.ScreenBRoute.route) {
            ScreenB(navController)
        }
    }
}
