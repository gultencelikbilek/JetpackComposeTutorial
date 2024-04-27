package com.example.jetpackcomposetutorial.jetpackcomposetutorial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JetpackTutorial() {

}

@Preview
@Composable
fun PreviewExample() {
    //  SurfaceTutorial()
    //  ColumnAndRowTutorial()
    //  BoxTutorial()
    //  ModifierTutorial()
    //  ButtonTutorial()
    //   StylingButton()

}

@Composable
fun StylingButton() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 60.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
                onClick = { /*TODO*/ },
        shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 20.dp)
        ) {
        Text(text = "Rounded corner button")

    }
        Button(
            onClick = { /*TODO*/ },
            shape = CutCornerShape(8.dp)
        ) {
            Text(text = "Cut corner button")

        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(100.dp),
            shape = CircleShape
        ) {
            Icon(imageVector =Icons.Filled.Add , contentDescription = "")
            //Text(text = "Circle button")
        }
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 6.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfffedbd0),
                contentColor = Color.Gray
            ),
            border = BorderStroke(1.dp,Color.Magenta)
        ) {
            Text(text = "Rounded corner button")
            Icon(imageVector =Icons.Filled.Face , contentDescription = "")


        }
    }
}

@Composable
fun ButtonTutorial() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {}
        ) {
            Text(text = "Simple Button")
        }
        OutlinedButton(onClick = {}
        ) {
            Text(text = "Outlined Button")
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }
        TextButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Text Button")
        }
        Button(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Add")
        }
    }
}

@Composable
fun ModifierTutorial() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Subscribe please",
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Green)
                .padding(10.dp)
            //.size(250.dp)
            //.fillMaxWidth()
            //.fillMaxHeight()
            , fontSize = 28.sp
        )
        Box(modifier = Modifier
            .padding(60.dp)
            .size(250.dp)
            .rotate(45f)//kutuyu 45 derece döndürüyor
            .alpha(0.1f)//şeffaflık ayarlar
            .clickable { RoundedCornerShape(20.dp) }
            .background(Color.Cyan)
            .border(3.dp, Color.Black, RoundedCornerShape(20.dp))
            .clickable {
                //buraya herhangi bir komut ekleyebilrim.
            }
        ) {

        }
    }
}

@Composable
fun BoxTutorial() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .width(250.dp)
                .height(250.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Green)
                    .width(150.dp)
                    .height(100.dp)
            ) {
                Text(text = "Subscribe please", fontSize = 28.sp)
            }
        }
    }
}

@Composable
fun ColumnAndRowTutorial() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = " Subscribe", fontSize = 28.sp)
        Text(text = " please", fontSize = 28.sp)
        Text(text = " Mkr", fontSize = 28.sp)
    }
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(text = " Subscribe", fontSize = 28.sp)
        Text(text = " please", fontSize = 28.sp)
        Text(text = " Mkr", fontSize = 28.sp)
    }

}


@Composable
fun SurfaceTutorial() {
    Surface(
        modifier = Modifier
            .height(150.dp)
            .width(250.dp)
            .padding(16.dp),
        // shape = CutCornerShape(8.dp),
        shape = RoundedCornerShape(28.dp),
        // shape = RoundedCornerShape(28.dp,28.dp),
        color = Color.Green,
        border = BorderStroke(2.dp, color = Color.Red),
        shadowElevation = 28.dp,
        tonalElevation = 100.dp,
        contentColor = Color.Blue,
        // content = {
        //     Text(text = " please", fontSize = 32.sp,modifier = Modifier.padding(10.dp))
//
        // }

    ) {
        Text(text = "Subscribe please", fontSize = 32.sp, modifier = Modifier.padding(10.dp))
    }
}