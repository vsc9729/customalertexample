package com.example.customalert

import CustomAlertDialog
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.example.customalert.ui.theme.CustomAlertTheme
import androidx.compose.material3.*

import androidx.compose.foundation.layout.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomAlertTheme {
                ExampleScreen()
            }
        }
    }
}

@Composable
fun ExampleScreen() {
    var showDialog by remember { mutableStateOf(false) }
    var resultText by remember { mutableStateOf<String?>(null) }

    // Example counter state to demonstrate custom actions
    var counter by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Counter: $counter",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { showDialog = true }) {
            Text("Show Alert Dialog")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display the last action result
        resultText?.let { text ->
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentSize(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        CustomAlertDialog(
            showDialog = showDialog,
            onDismissRequest = { result->
                showDialog = false
                resultText = result
            },
            title = "Counter Control",
            message = "Would you like to increment or decrement the counter?",
            confirmButtonText = "Increment",
            cancelButtonText = "Decrement",
            onConfirmClick = {
                counter++
                Log.d("CustomAlertDialog", "Counter incremented")
            },
            onCancelClick = {
                counter--
                Log.d("CustomAlertDialog", "Counter decremented")
            }
        )
    }
}