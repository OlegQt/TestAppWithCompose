package com.oleg.testappwithcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import kotlin.math.cos
import kotlin.math.sin

class RootActivity : ComponentActivity() {
    private lateinit var viewModel: RootViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[RootViewModel::class.java]

        setContent {
            ShowApp()
        }
    }

    companion object {
        const val SHADOW_OFFSET_MULTIPLIER = 14.0F
    }


    // Some M3 APIs are considered experimental.
    // In such cases you need to opt in at the function or file level using the ExperimentalMaterial3Api annotation:
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ShowApp() {
        Scaffold(
            topBar = showAppBar,
            content = { showContent(it) }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    val showAppBar: @Composable () -> Unit = {
        TopAppBar(
            title = { ShowTextWithShadow(textLine = "Compose") },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        )
    }

    val showContent: @Composable (PaddingValues) -> Unit = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Divider()
            Text(text = "Padding from AppBar = ${it.toString()}")
            Divider()
        }
    }

    @Composable
    fun ShowTextWithShadow(textLine: String) {
        val countState = viewModel.count.observeAsState()

        val shadowAngle = countState.value ?: 0.0F
        val shadowOffsetX = sin(shadowAngle) * SHADOW_OFFSET_MULTIPLIER
        val shadowOffsetY = cos(shadowAngle) * SHADOW_OFFSET_MULTIPLIER

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = textLine,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontStyle = FontStyle.Italic,
                fontSize = 40.sp,
                shadow = Shadow(
                    color = MaterialTheme.colorScheme.primary,
                    offset = Offset(shadowOffsetX, shadowOffsetY),
                    blurRadius = 10.5f
                )
            )
        )
    }

    @Preview
    @Composable
    fun ShowShadowTxtPreview() {
        ShowApp()
    }
}