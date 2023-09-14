package com.example.forelesning5.ui.theme.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HomeScreen() {
    Text(text = "Welcome hom!",
        style = MaterialTheme.typography.headlineLarge,
        textAlign = TextAlign.Center)
}