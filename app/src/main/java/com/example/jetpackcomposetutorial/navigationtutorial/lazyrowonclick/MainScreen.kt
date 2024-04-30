package com.example.jetpackcomposetutorial.navigationtutorial.lazyrowonclick

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(
    imageId: Array<Int>,
    names: Array<String>,
    ingredients: Array<String>,
    modifier: Modifier = Modifier,
    navContorller: NavHostController
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        val itemCount = imageId.size

        items(itemCount){
            ColumnItem(modifier,painter = imageId,title=names,ingredients =ingredients,itemIndex =it,navContorller =navContorller)
        }
    }
}

@Composable
fun ColumnItem(
    modifier: Modifier,
    painter: Array<Int>,
    title: Array<String>,
    ingredients: Array<String>,
    itemIndex: Int,
    navContorller: NavHostController
) {
    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navContorller.navigate("detail_screen/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation =  CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(painter = painterResource(id = painter[itemIndex]), contentDescription = null ,modifier.size(140.dp))

            Column(modifier.padding(12.dp)) {
                Text(text = title[itemIndex], fontSize = 14.sp)
                Text(text = ingredients[itemIndex], fontSize = 12.sp)

            }
        }
    }
}
