package com.example.jetpackcomposetutorial.jetpackcomposetutorial

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScaffoldTutorialJetpackCompose() {

}

@Preview
@Composable
fun ScaffoldPreview() {
    ScaffoldTutorial()
}

data class NavItemState(
    val title :String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBdge : Boolean,
    val badgeNum : Int
)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldTutorial() {
    val items= listOf(
        NavItemState(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasBdge = false,
            badgeNum = 0
        ),
        NavItemState(
            title = "Inbox",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            hasBdge = true,
            badgeNum = 10
        ),
        NavItemState(
            title = "Account",
            selectedIcon = Icons.Filled.Face,
            unselectedIcon = Icons.Outlined.Face,
            hasBdge = true,
            badgeNum = 0
        )

    )
    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    Text(text = "Top App Bar")
                }
            },
                modifier = Modifier.padding(10.dp).clip(RoundedCornerShape(20.dp)),
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu Icon"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        BadgedBox(badge = {
                            Badge (modifier = Modifier.size(10.dp)){

                            }
                        }) {
                            Icon(
                                imageVector = Icons.Outlined.FavoriteBorder,
                                contentDescription = "Fav Icon"
                            )
                        }
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Outlined.ShoppingCart,
                            contentDescription = "ShoppingCart Icon"
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFE0A9A5)
                )
            )
        },
        bottomBar = {
            NavigationBar(
                Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp)),
                containerColor = Color(0xFFE0A9A5)
            ) {
                items.forEachIndexed{index, item ->

                    NavigationBarItem(
                        selected = bottomNavState == index ,
                        onClick = { bottomNavState = index },
                        icon = {
                            BadgedBox(badge = {
                                if (item.hasBdge) Badge {}
                                if (item.badgeNum  != 0) Badge {
                                    Text(text = item.badgeNum.toString())
                                }
                            }) {
                                Icon(
                                    imageVector =if (bottomNavState == index) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = item.title)
                            }
                        },
                        label = {
                            Text(text = item.title)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF552A27),
                            selectedTextColor = Color(0xFF63332F),
                            indicatorColor = Color(0xFFBB7E7A)
                        )
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp),
                containerColor = Color(0xFFFFEB3B)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        }
    ) {  paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment =  Alignment.CenterHorizontally
        ) {
            Text(text = items[bottomNavState].title, fontWeight = FontWeight.ExtraBold, fontSize = 44.sp)

        }
    }
}
