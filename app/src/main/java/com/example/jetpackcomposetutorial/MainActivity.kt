package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.JetpackTutorial
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.ScaffoldPreview
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.TabScreen
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.nested.ChildDataClass
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.nested.Nested
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.nested.ParentDataClass
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.nested.nestedsharedtranstions.DetailsScreen
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.nested.nestedsharedtranstions.ListScreen
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    private val parentItemList = ArrayList<ParentDataClass>()

    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    SharedTransitionLayout {

                        NavHost(navController = navController, startDestination = "list") {
                            composable("list") {
                                ListScreen(
                                    animatedVisibilityScope = this,
                                    onItemClick = { resId, text ->
                                        navController.navigate("detail/$resId/$text")
                                    }
                                )
                            }
                            composable(
                                route = "detail/{resId}/{text}",
                                arguments = listOf(navArgument("resId") {
                                    type = NavType.IntType
                                },
                                    navArgument("text") {
                                        type = NavType.StringType
                                    }
                                )
                            ) { navBackEntry ->

                                DetailsScreen(
                                    animatedVisibilityScope = this,
                                    resId = navBackEntry.arguments!!.getInt("resId") ?: 0,
                                    text = navBackEntry.arguments!!.getString("text") ?: ""
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    fun setData() {
        val images = listOf(
            ChildDataClass(R.drawable.book1),
            ChildDataClass(R.drawable.book2),
            ChildDataClass(R.drawable.book3),
            ChildDataClass(R.drawable.book4),
            ChildDataClass(R.drawable.book5),
            ChildDataClass(R.drawable.book6),
            ChildDataClass(R.drawable.book7),
            ChildDataClass(R.drawable.book8),
            ChildDataClass(R.drawable.book9),
            ChildDataClass(R.drawable.book10),
            ChildDataClass(R.drawable.book11),
            ChildDataClass(R.drawable.book12),
            ChildDataClass(R.drawable.book13),
            ChildDataClass(R.drawable.book14),
        )
        parentItemList.add(ParentDataClass("Novel:", images))
        parentItemList.add(ParentDataClass("Best Seller:", images.shuffled()))
        parentItemList.add(ParentDataClass("History:", images.reversed()))
        parentItemList.add(ParentDataClass("Favorite:", images.shuffled()))
        parentItemList.add(ParentDataClass("Crime:", images))
        parentItemList.add(ParentDataClass("Drama:", images.shuffled()))
        parentItemList.add(ParentDataClass("New Topics:", images.shuffled()))
    }

}

