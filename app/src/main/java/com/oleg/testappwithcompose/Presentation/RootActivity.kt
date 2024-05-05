package com.oleg.testappwithcompose.Presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider

class RootActivity : ComponentActivity() {
    lateinit var viewModel: RootViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[RootViewModel::class.java]
        
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
                ShowTextWithShadow(textLine = "Compose")
            }
        }
    }


    @Composable
    fun ShowTextWithShadow(textLine:String) {
        val countState = viewModel.count.observeAsState()

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = textLine.plus(" ${countState.value}"),
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

    @Preview
    @Composable
    fun ShowShadowTxtPreview(){
       ShowApp()
    }

}