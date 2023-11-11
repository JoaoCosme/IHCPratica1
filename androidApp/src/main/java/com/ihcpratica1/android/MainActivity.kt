package com.ihcpratica1.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SumNumbers()
                }
            }
        }
    }
}

@Composable
fun SumNumbers(){
    var num1 by remember { mutableStateOf("0") }
    var num2 by remember { mutableStateOf("0") }
    var sumResult by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Atividade 1", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        TextField(value = num1, onValueChange = {num1 = it}, label = { Text(text = "Numero 1")})
        TextField(value = num2, onValueChange = {num2 = it}, label = { Text(text = "Numero 2")})
        Button(onClick = {sumResult = (num1.toInt() + num2.toInt()).toString()}) {
            Text("Somar!")
        }
        Text(text = sumResult,
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
    }
}
@Preview
@Composable
fun DefaultPreview() {
        SumNumbers()
}
