package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.Screen.BreathingExerciseScreen
import com.example.navigation.Screen.HomeScreen
import com.example.navigation.Screen.MeditationDetailsScreen
import com.example.navigation.Screen.SelectMeditationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                composable("home") {
                    HomeScreen(
                        name = "Nikolaj",
                        onStartMeditationClick = {
                            navController.navigate("select")
                        }
                    )
                }

                composable("select") {
                    SelectMeditationScreen(
                        onBeginClick = {
                            // Her kunne du normalt sende valgt type/tid videre
                            navController.navigate("breathing")
                        },
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }

                composable("details") {
                    MeditationDetailsScreen(
                        onReturnHomeClick = {
                            // Gå tilbage til home og ryd stacken op til den
                            navController.popBackStack("home", inclusive = false)
                        }
                    )
                }

                composable("breathing") {
                    BreathingExerciseScreen(
                        onBackClick = { navController.popBackStack() },
                        onStartExerciseClick = {

                        }
                    )
                }

            }
        }
    }
}
