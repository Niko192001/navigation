package com.example.heart2heart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heart2heart.screens.BellyBreathingScreen
import com.example.heart2heart.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "Belly Breathing Screen"
            ) {

                composable("Belly Breathing Screen") {
                    BellyBreathingScreen(
                        onBackClick = {
                            navController.navigate("Home Screen")
                        }
                    )
                }

                composable ("Home Screen"){
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun BackButton(onBackClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFFFF69B4)
            )
        }
        Text(
            text = "Back",
            color = Color(0xFFFF69B4),
            fontSize = 14.sp
        )
    }
}
