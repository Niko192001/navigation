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
fun HomeScreen(
    name: String,
    onStartMeditationClick: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Welcome, $name.",
            fontSize = 28.sp
        )
        Text(
            text = "Your daily calm awaits.",
            fontSize = 18.sp
        )

        Button(
            onClick = onStartMeditationClick,
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFE77B7) // vores farve
            )

        ) {
            Text("START MEDITATION")
        }

        Text(
            text = "Recent Sessions",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 24.dp)
        )

        Text("15 min • Oct 26 • Focus")
        Text("10 min • Oct 25 • Sleep")
        Text("20 min • Oct 24 • Calm")
    }
}
