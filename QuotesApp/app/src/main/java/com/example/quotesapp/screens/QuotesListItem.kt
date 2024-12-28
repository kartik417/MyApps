package com.example.quotesapp.screens


import android.R
import android.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close

import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent



@Composable
fun showQuoteListItems(){
    Card (

        modifier = Modifier.padding(8.dp),



    ){
        Row (
            modifier = Modifier.padding(16.dp)
        ){
            Image(
                imageVector = Icons.Filled.Close,

                alignment = Alignment.TopStart,
                contentDescription = "Close",
                modifier = Modifier.size(40.dp).
                rotate(180F).background(Color.White)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column (
                modifier = Modifier.weight(1f)

            ) {
                Text(text = "Time is most valuable thing a man can spend",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp))
                Box(modifier = Modifier.background(Color.Gray).fillMaxWidth(.4f).height(1.dp))
                Text(text = "Theophrastus",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun quoteDetails(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f).background(
            Brush.sweepGradient(
                colors = listOf(
                    Color(0xFFffffff),
                    Color(0xFFE3E3E3)))
                )
            ){
        Card(

            modifier = Modifier.padding(32.dp)
        )
        {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp,24.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.Close,
                    fontFamily = FontFamily(Font(R.style.)
                )
            }
        }
    }


}