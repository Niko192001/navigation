package com.example.navigation.screen

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

        Text("12 min • Oct 10 • Pursed lip breathing")
        Text("6 min • Oct 15 • Belly breathing")
        Text("9 min • Oct 30 • Box breathing")
    }
}
