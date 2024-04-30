package com.example.jetpackcomposetutorial.navigationtutorial.nestednavigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.navigationjetpackcompose.nestednavigation.LoginScreen
import com.example.navigationjetpackcompose.nestednavigation.RegisterScreen
import com.example.navigationjetpackcompose.nestednavigation.Screen

fun NavGraphBuilder.authGraph(navController: NavHostController){
    navigation(
        startDestination = Screen.ScreenLoginRoute.route,
        route = Screen.AuthRoute.route
    ) {
        composable(Screen.ScreenLoginRoute.route) {
            LoginScreen(navController)
        }
        composable(Screen.ScreenRegisterRoute.route) {
            RegisterScreen(navController)
        }
        composable(Screen.ScreenForgotPassRoute.route) {
            ForgotScreen(navController)
        }
    }
}