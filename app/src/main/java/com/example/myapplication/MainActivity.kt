package com.example.myapplication

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
                        LearnRowColumnBox()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LearnRowColumnBox(){

    Box(modifier = Modifier.fillMaxSize().background(Color.Yellow), contentAlignment = Alignment.Center){
        Box(modifier = Modifier.height(300.dp).width(300.dp).background(color = Color.Blue), contentAlignment = Alignment.Center) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Hello Row", color = Color.White)
                Text(text = " Hello Row")
                Text(text = " Hello Row")
            }
        }
    }

//    Spacer(modifier = Modifier.height(16.dp))
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
//    ){
//        Text(text = "Hello Column")
//        Text(text = "Hello Column")
//        Text(text = "Hello Column")
//    }


}