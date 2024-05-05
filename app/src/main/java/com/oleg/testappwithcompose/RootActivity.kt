package com.oleg.testappwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class RootActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShowApp()
        }
    }


    @Composable
    fun ShowApp() {
        ShowLayout()
    }

    @Composable
    fun ShowLayout() {
        Column() {
            Box(
                modifier = Modifier
                    .weight(weight = 0.4f)
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
            ) {

            }
            Box(
                modifier = Modifier
                    .weight(weight = 0.4f)
                    .fillMaxWidth()
                    .background(color = Color.DarkGray)
            ) {

            }
            Box(
                modifier = Modifier
                    .weight(weight = 0.2f)
                    .fillMaxWidth()
                    .background(color = Color.Red)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Hello",
                    color = Color.LightGray,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontSize = 40.sp,
                        shadow = Shadow(
                            color = Color.DarkGray,
                            offset = Offset(0.2f, 10.2f),
                            blurRadius = 10.5f
                        )
                    )
                )
            }
        }
    }
}