package com.example.navigation.Screen



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

@Composable
fun MeditationDetailsScreen(
    onReturnHomeClick: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Meditation Details",
            fontSize = 24.sp
        )

        Text(
            text = "Date: March 23, 2026",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text("Duration: 10 Minutes")
        Text("Type: Focus Meditation")

        Button(
            onClick = onReturnHomeClick,
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFE77B7) // vores farve
            )

        ) {
            Text("RETURN TO HOME")
        }
    }
}
