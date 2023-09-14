package com.example.forelesning5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.forelesning5.ui.theme.Forelesning5Theme
import com.example.forelesning5.ui.theme.ui.HomeScreen
import com.example.forelesning5.ui.theme.ui.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Forelesning5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationApp()

                }
            }
        }
    }
}

enum class Screen {
    Login,
    Home
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    Scaffold(topBar =  {
        TopAppBar(title = { Text(text = "Navigation") })
    }) { innerPadding ->
        NavHost(navController = navController,
            startDestination = Screen.Login.name,
            modifier = Modifier.padding(innerPadding)) {
            composable(Screen.Login.name) { LoginScreen(login = { navController.navigate("home") }) }
            composable(Screen.Home.name) { HomeScreen() }
        }
    }
}

