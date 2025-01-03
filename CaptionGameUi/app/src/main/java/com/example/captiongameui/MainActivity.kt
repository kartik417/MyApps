package com.example.captiongameui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.captiongameui.ui.theme.CaptionGameUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptionGameUiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    CaptainGame()
                }
            }
        }
    }
    @Composable
    fun CaptainGame(){
        Column {
           val treasureCount = remember { mutableStateOf(0) }
            val treasureDirection = remember { mutableStateOf("East") }

            Text(text = "Treasure Count: ${treasureCount.value}")
            Text(text = "Treasure Direction: ${treasureDirection.value}")
            Button(onClick = {
                treasureCount.value++
                treasureDirection.value = "East"
            }) {
                Text(text = "Sail East")
            }
            Button(onClick = {
                treasureCount.value++
                treasureDirection.value = "West"
            }){
                Text(text = "Sail West")
            }
            Button(onClick = {
                treasureCount.value++
                treasureDirection.value = "North"
            }) {
                Text(text = "Sail North")
            }
            Button(onClick = {
                treasureCount.value++
                treasureDirection.value = "South"
            }) {
                Text(text = "Sail South")
            }

        }
    }
}

