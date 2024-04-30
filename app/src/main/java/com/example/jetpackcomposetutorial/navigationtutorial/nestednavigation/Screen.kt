package com.example.navigationjetpackcompose.nestednavigation

sealed class Screen(val route:String) {
    object ScreenLoginRoute:Screen(route = "login_screen")
    object ScreenForgotPassRoute : Screen(route = "forgot_screen")
    object ScreenRegisterRoute : Screen(route = "register_screen")
    object ScreenHomeRoute : Screen(route = "home_screen")
    object ScreenBRoute : Screen(route = "b_screen")
    object ScreenARoute : Screen(route = "a_screen")
    object AuthRoute: Screen(route="Auth")
    object AppRoute: Screen(route="App")
}