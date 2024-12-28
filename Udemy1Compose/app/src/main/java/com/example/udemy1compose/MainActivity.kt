package com.example.udemy1compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.udemy1compose.ui.theme.Udemy1ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Udemy1ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConvertor()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConvertor() {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
    ){

            Text(text = "Unit Convertor")
        Spacer(modifier = Modifier.padding(8.0.dp))
            OutlinedTextField(value = "Enter value", onValueChange = {})
        Spacer(modifier = Modifier.padding(8.0.dp))
            Row {
                Box{
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Select")
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "ArrowDropDown")
                    }
                    DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                        DropdownMenuItem(text = { Text(text = "Kilometer") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Meter") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Millimeter") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Inch") }, onClick = { /*TODO*/ })
                    }

                }
                Spacer(modifier = Modifier.width(16.dp))
                Box{
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Select")
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "ArrowDropDown")
                    }
                    DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                        DropdownMenuItem(text = { Text(text = "Kilometer") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Meter") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Millimeter") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Inch") }, onClick = { /*TODO*/ })
                    }
                }
            }

        Text(text = "Result:")

    }
}