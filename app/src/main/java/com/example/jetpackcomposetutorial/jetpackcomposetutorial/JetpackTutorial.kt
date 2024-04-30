package com.example.jetpackcomposetutorial.jetpackcomposetutorial

import android.inputmethodservice.Keyboard.Row
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.R

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
    //  StylingButton()
    //  StateTutorial()
    //  StylingTextTutorial()
    //  TextFieldAndToastMessageTutorial()
    //  StylingTextFieldTutorial()
    //  ImageTutorial()
    //  CardTutorial()
    val languages = listOf(
        "Java",
        "Kotlin",
        "Python",
        "Dart",
        "Php",
        "XML",
        "HTML",
        "JavaScript",
        "R",
        "Go",
        "C++",
        "Swift",
        "Verilog"
    )
    LazyRowAndColumnTutorial(languages)

}

@Composable
fun LazyRowAndColumnTutorial(languages: List<String>) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyRow(contentPadding = PaddingValues(10.dp)) {
            items(languages){
                RowItem(name = it)
            }
        }
        LazyColumn(contentPadding = PaddingValues(10.dp)){
            items(languages){
                ColumnItem(name = it)
            }
        }
    }
}

@Composable
fun ColumnItem(name: String) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1.5f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun RowItem(name: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
            .aspectRatio(1.5f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun CardTutorial() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(270.dp),
            //shape = CutCornerShape(20.dp)
            elevation = CardDefaults.cardElevation(10.dp),
            //  border = BorderStroke(3.dp,Color.Gray)
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.persepolis),
                    contentDescription = ""
                )
                Text(
                    text = "Title",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make ",
                    fontSize = 13.sp,
                    modifier = Modifier.padding(6.dp),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray
                )
            }

        }
    }
}

@Composable
fun ImageTutorial() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.persepolis),
            contentDescription = "pic",
            Modifier
                .padding(10.dp)
                //.size(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(2.dp, Color.Red, RoundedCornerShape(16.dp)),
            //contentScale = ContentScale.Crop // resmi verilen alana tam sığdırır.
            //contentScale = ContentScale.FillBounds // resmi verilen alana dikey olarak alana sığrdırır
            contentScale = ContentScale.FillWidth,
            //alpha = .2f

        )
        Image(
            painter = painterResource(id = R.drawable.persepolis),
            contentDescription = "pic",
            Modifier
                .padding(10.dp)
                //.size(200.dp)
                .clip(CutCornerShape(16.dp))
                .border(2.dp, Color.Red, RoundedCornerShape(16.dp)),
            //contentScale = ContentScale.Crop // resmi verilen alana tam sığdırır.
            //contentScale = ContentScale.FillBounds // resmi verilen alana dikey olarak alana sığrdırır
            contentScale = ContentScale.FillWidth,
            //alpha = .2f
        )
        Image(
            painter = painterResource(id = R.drawable.persepolis),
            contentDescription = "pic",
            Modifier
                .padding(10.dp)
                .size(200.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Red, CircleShape),
            //contentScale = ContentScale.Crop // resmi verilen alana tam sığdırır.
            //contentScale = ContentScale.FillBounds // resmi verilen alana dikey olarak alana sığrdırır
            contentScale = ContentScale.FillWidth,
            //alpha = .2f
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StylingTextFieldTutorial() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 40.dp),
        contentAlignment = Alignment.Center
    ) {
        var textState by remember {
            mutableStateOf("")
        }
        val myColor = Color(0xFFD50000)

        TextField(
            value = textState,
            onValueChange = { textState = it },
            modifier = Modifier.padding(top = 20.dp),
            label = { Text(text = "your name") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                    tint = myColor
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Send,
                    contentDescription = ""
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = myColor,
                focusedLabelColor = myColor,
                cursorColor = myColor,
                disabledTextColor = myColor,
                focusedLeadingIconColor = myColor,
                unfocusedLeadingIconColor = myColor,
                focusedTrailingIconColor = myColor,
                unfocusedTrailingIconColor = myColor,
                unfocusedIndicatorColor = myColor.copy(.5f),
                focusedIndicatorColor = myColor,
                containerColor = myColor.copy(.2f)
            ),
            shape = RoundedCornerShape(25.dp)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldAndToastMessageTutorial() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var newTextValue by remember {
            mutableStateOf("")
        }
        val context = LocalContext.current

        val keyboardController = LocalSoftwareKeyboardController.current

        val focusManager = LocalFocusManager.current

        Column(
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            TextField(
                value = newTextValue,
                onValueChange = {
                    newTextValue = it
                },
                label = {
                    Text(text = "Enter your email") //textfield için bilgi verir(hint gibi)
                },
                // maxLines = 2,//kaç satır yazabilceğimi belirtir.
                singleLine = true,// textfield satırının alt alta yazma yerine yanyana yazarak textfield alanının genişlemesi
                modifier = Modifier.width(250.dp),//satırının genişleme boyutunu veriyoruz
                placeholder = { // verilen textfieldin nasıl doldurulacağı hakkında bilgi verir.
                    Text(text = "test@gmail.com")
                },
                visualTransformation = PasswordVisualTransformation(),  //şifre olduğu için göstermez
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = ""
                    ) //Textfieldın başına icon ekler
                },
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, newTextValue, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Send,
                            contentDescription = ""
                        ) //Textfieldin sonuna icon ekler
                    }
                },

                )

            OutlinedTextField(
                value = newTextValue,
                onValueChange = {
                    newTextValue = it
                },
                label = {
                    Text(text = "Enter your email") //textfield için bilgi verir(hint gibi)
                },
                // maxLines = 2,//kaç satır yazabilceğimi belirtir.
                singleLine = true,// textfield satırının alt alta yazma yerine yanyana yazarak textfield alanının genişlemesi
                modifier = Modifier.width(250.dp),//satırının genişleme boyutunu veriyoruz
                placeholder = { // verilen textfieldin nasıl doldurulacağı hakkında bilgi verir.
                    Text(text = "test@gmail.com")
                },
                // visualTransformation = PasswordVisualTransformation(),  //şifre olduğu için göstermez
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = ""
                    ) //Textfieldın başına icon ekler
                },
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, newTextValue, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Send,
                            contentDescription = ""
                        ) //Textfieldin sonuna icon ekler
                    }
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters, //klavyeye özellik veririz.
                    keyboardType = KeyboardType.Phone, //klavyede sayılar olur
                    imeAction = ImeAction.Send
                ),
                keyboardActions = KeyboardActions(
                    onSend = {
                        keyboardController?.hide()
                        Toast.makeText(context, "send button pressed", Toast.LENGTH_SHORT).show()
                        focusManager.clearFocus()
                    }
                )
            )
            BasicTextField(
                value = "sub please",
                onValueChange = {},
                modifier = Modifier
                    .width(300.dp)
                    .background(Color.LightGray)
            ) {

            }
        }
    }
}

@Composable
fun StylingTextTutorial() {
    val myFont = FontFamily(Font(R.font.courgette))
    Text(
        stringResource(id = R.string.sub).repeat(30),
        // modifier = Modifier.background(Color.Gray).width(400.dp),
        color = Color.Blue,
        fontSize = 25.sp,
        //  fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontFamily = myFont,
        //letterSpacing = 15.sp,//harfler arası boşluk oluşturur
        //textDecoration = TextDecoration.LineThrough //yazının üstünü çizer
        // textAlign = TextAlign.Center //yazıyı ortalar
        lineHeight = 40.sp,
        overflow = TextOverflow.Ellipsis,//sonuna 3 nokta atar
        maxLines = 3 //3 satır görüntülenir
    )
    Text(text = buildAnnotatedString {
        withStyle(
            style = ParagraphStyle(textIndent = TextIndent(firstLine = 20.sp))
        ) {
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontSize = 30.sp
                )
            ) {
                append("J")
            }

            append("etpack")

            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontSize = 30.sp
                )
            ) {
                append("C")
            }

            append("OMPOSE")
        }
    })
}

@Composable
fun StateTutorial() {
    var count by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 60.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            count++
            Log.d("Count:", "${count}")
        }) {
            Text(text = "Count = ${count}")
        }
        Spacer(modifier = Modifier.size(25.dp))
        Text(text = "Count = ${count}")
    }
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
            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
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
            border = BorderStroke(1.dp, Color.Magenta)
        ) {
            Text(text = "Rounded corner button")
            Icon(imageVector = Icons.Filled.Face, contentDescription = "")


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