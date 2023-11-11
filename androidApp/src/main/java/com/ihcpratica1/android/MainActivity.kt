package com.ihcpratica1.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

private const val ACT_2_INPUT = "act2-input"

private const val ACT_2_DISPLAY = "act2-displaY"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val viewModel = viewModel<SharedViewModel>();
                    NavHost(navController = navController, startDestination = "act1" ){
                        composable("act1"){ SumNumbers(navController)}
                        composable(ACT_2_INPUT){ Act2InputDeTexto(navController,viewModel) }
                        composable(ACT_2_DISPLAY){ Act2MostrarTexto(navController,viewModel)}
                    }
                }
            }
        }
    }
}

@Composable
fun SumNumbers(navController: NavHostController) {
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
        Button(onClick = { navController.navigate(ACT_2_INPUT) }) {
            Text(text = "Ir para Atividade 2!")
        }
    }
}

@Composable
fun Act2InputDeTexto(navController: NavHostController, viewModel: SharedViewModel) {
    val mutableValue = remember { viewModel.mutableValue }
    val inputState = remember { mutableStateOf(TextFieldValue(mutableValue)) }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Atividade 2", fontSize = 24.sp, fontWeight = FontWeight.Bold);
        BasicTextField(value = inputState.value, onValueChange = {
            inputState.value = it;
            viewModel.updateMutableValue(inputState.value.text);
        })
        Button(onClick = { navController.navigate(ACT_2_DISPLAY) }) {
            Text(text = "Veja o que voce escreveu!")
        }
    }
}

@Composable
fun Act2MostrarTexto(navController: NavHostController, viewModel: SharedViewModel){
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Atividade 2", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = viewModel.mutableValue,
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
    }
}