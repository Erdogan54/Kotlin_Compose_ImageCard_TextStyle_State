package com.ozgurerdogan.kotlin_compose_imagecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.ozgurerdogan.kotlin_compose_imagecard.ui.theme.Kotlin_Compose_ImageCardTheme
import com.ozgurerdogan.kotlin_compose_imagecard.ui.theme.Shapes
import kotlin.math.absoluteValue
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var color by remember {
                mutableStateOf(Color.Yellow)
            }

            Column {
                ColorBox(Modifier.fillMaxSize().weight(1f)){
                    color=it
                }

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(color)
                    .weight(1f))
            }




        }
    }
}



@Composable
fun ColorBox(
    modifier:Modifier=Modifier,
    updateColor:(Color)->Unit
    ) {

    Box(
        modifier = modifier
            .background(Color.Red)
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f

                    )
                )

            }

    )
}


@Composable
fun StylingText() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ){
        Text(
            text = buildAnnotatedString {
                                        withStyle(
                                            style = SpanStyle(
                                                fontSize = 50.sp,
                                                color = Color.Green
                                            )
                                        ){
                                            append("J")
                                        }
                append("etpack")
                append("\n\n")
                append("\t\t\t\t\t")

                withStyle(
                    style = SpanStyle(
                        color=Color.Green,
                        fontSize = 50.sp
                    )
                ){
                    append("C")
                }
                append("ompose")
            }

            ,
            color=Color.White,
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline



            )

    }
}

@Composable
fun ViewImageCard() {
    val painter= painterResource(id = R.drawable.ayasofya2)
    val description="Ayasofya"
    val title="Ayasofya"

    Box(modifier = Modifier
        .fillMaxWidth(0.5f)
        .padding(16.dp)
    ){
        ImageCard(painter = painter, contentDescription = description, title = title)
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier =Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)){
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
            )

            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f

                    )
                )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(text = title,style = TextStyle(color= Color.White,fontSize = 16.sp,))

            }
        }

    }

}
