package com.example.littlelemonanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonanimation.ui.theme.LittleLemonAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var visible by remember { mutableStateOf(true) } // Initialize as a mutable state

    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center, Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Text(
                    text = "Hello World",
                    fontSize = 48.sp
            )
        }

        Button(
            onClick = { visible = !visible }, // Toggle visibility when button is clicked
            modifier = Modifier.padding(vertical = 8.dp) // Add some padding for better spacing
        ) {
            Text(
                text = if (visible) "Hide" else "Show",
                fontSize = 48.sp
            ) // Text indicating the action
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LittleLemonAnimationTheme {
        Greeting()
    }
}