package com.example.jetpackcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose1.ui.theme.JetpackCompose1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        listView()
        }
    }


}
@Composable
fun listView(){
    Row {
        Vertical
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
        Column {
            Text(text = "John Doe", fontWeight = FontWeight.Bold)
            Text(text = "Software Developer", fontSize = 16.sp)
            Text(text = "123 Main Street")
        }
    }
}