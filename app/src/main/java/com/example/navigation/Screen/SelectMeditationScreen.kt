package com.example.navigation.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectMeditationScreen(
    onBeginClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Select Meditation Type",
            fontSize = 24.sp
        )

        Text("Focus", modifier = Modifier.padding(top = 16.dp))
        Text("Sleep")
        Text("Calm")

        Text(
            text = "Time: 10:00",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

        Button(
            onClick = onBeginClick,
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFE77B7) // vores farve
            )
        ) {
            Text("BEGIN")
        }

        Button(
            onClick = onBackClick,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFE77B7) // vores farve
            )
        ) {
            Text("Back")
        }
    }
}
