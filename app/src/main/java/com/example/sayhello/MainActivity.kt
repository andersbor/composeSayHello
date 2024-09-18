package com.example.sayhello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.sayhello.ui.theme.SayHelloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayHelloTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SayHello(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// Phone must be open (not screen locked) to run the test
@Composable
fun SayHello(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        Text("Say Hello", style = MaterialTheme.typography.headlineLarge)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Enter your name") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Button(onClick = { message = name.ifEmpty { "nobody" } })
            {
                Text("Say Hello")
            }
        }
        Text(text = "Hello $message!")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SayHelloTheme {
        SayHello()
    }
}