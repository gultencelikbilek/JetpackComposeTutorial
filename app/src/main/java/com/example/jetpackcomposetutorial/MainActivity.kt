package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.JetpackTutorial
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.TabScreen
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.nested.ChildDataClass
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.nested.Nested
import com.example.jetpackcomposetutorial.jetpackcomposetutorial.nested.ParentDataClass
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
   private val parentItemList = ArrayList<ParentDataClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //   JetpackTutorial()
                    //setData()
                   // Nested(parentItemList)
                    TabScreen()
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
        parentItemList.add(ParentDataClass("Novel:",images))
        parentItemList.add(ParentDataClass("Best Seller:",images.shuffled()))
        parentItemList.add(ParentDataClass("History:",images.reversed()))
        parentItemList.add(ParentDataClass("Favorite:",images.shuffled()))
        parentItemList.add(ParentDataClass("Crime:",images))
        parentItemList.add(ParentDataClass("Drama:",images.shuffled()))
        parentItemList.add(ParentDataClass("New Topics:",images.shuffled()))
    }

}

