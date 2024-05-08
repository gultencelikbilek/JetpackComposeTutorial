package com.example.jetpackcomposetutorial.jetpackcomposetutorial.nested

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NestedLazyColumnLazyRow(modifier: Modifier = Modifier) {
    val parentItemList = ArrayList<ParentDataClass>()
    Nested(parentItemList)
}


@Composable
fun Nested(parentItemList: ArrayList<ParentDataClass>) {

    NestedLazyColumnLazyRowTutorial(parentItemList)
}


@Composable
fun NestedLazyColumnLazyRowTutorial(parentItemList: ArrayList<ParentDataClass>) {
    LazyColumn(contentPadding = PaddingValues(15.dp)) {
        items(parentItemList.size) {
            ColumnItemUI(
                parentList = parentItemList,
                itemIndex = it
            )
        }
    }
}

@Composable
fun RowItemUI(childList: List<ChildDataClass>, itemIndex: Int) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .width(160.dp)
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xff201e1e))
    ) {
        Image(painter = painterResource(id = childList[itemIndex].image), contentDescription = null,modifier = Modifier.fillMaxSize())

    }
}

@Composable
fun ColumnItemUI(parentList: ArrayList<ParentDataClass>, itemIndex: Int) {
    Card(
        modifier = Modifier.padding(12.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        )
    ) {
        Text(
            text = parentList[itemIndex].title,
            modifier = Modifier.padding(12.dp),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFc107)
        )
        LazyRow(
            modifier = Modifier.padding(paddingValues = PaddingValues(12.dp))
        ) {
            items(parentList[itemIndex].childDataClass.size) {
                RowItemUI(
                    childList = parentList[itemIndex].childDataClass,
                    itemIndex = it
                )
            }
        }
    }
}

