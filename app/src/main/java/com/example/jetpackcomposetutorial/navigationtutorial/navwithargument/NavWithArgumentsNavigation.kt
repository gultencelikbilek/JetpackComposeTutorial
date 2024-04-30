package com.example.jetpackcomposetutorial.navigationtutorial.navwithargument

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavWithArgumentsNavigation() {
    val navContorller = rememberNavController()

    NavHost(navController = navContorller, startDestination = "home_screen" ){
        composable(route = "home_screen"){
            HomeScreen(navContorller)
        }
        composable(
            // route = "details_screen/{name}/{age}",
            route= "details_screen?name={name}&age={age}",
            arguments = listOf(
                navArgument(name = "name"){
                    type = NavType.StringType
                    //  defaultValue="user"
                    // nullable=true
                },
                navArgument(name = "age"){
                    type = NavType.IntType
                    //defaultValue =0
                }
            )
        ){backstackEntry ->
            DetailScreen(
                myName =backstackEntry.arguments?.getString("name"),
                myAge = backstackEntry.arguments?.getInt("age")
            )
        }
    }
}