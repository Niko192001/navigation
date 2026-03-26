package com.example.navigation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import com.example.navigation.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height


@Composable
fun BreathingExerciseScreen(
    onBackClick: () -> Unit,
    onStartExerciseClick: () -> Unit
) {
    @Composable
    fun BackButton(onBackClick:()-> Unit){
        IconButton(onClick=onBackClick){
            Icon(
                painter = painterResource(id = R.drawable.arrowicon),
                contentDescription = "Back"
            )
        }
    }
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Top: Back + Title
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onBackClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFE77B7)
                )
            ) {
                Text("Back")
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Pursed Lip Breathing",
                fontSize = 20.sp,
                color = Color(0x88FE77B7)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Step indicator
        Text(
            text = "Take a Breath 5.",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Illustrations (placeholder text)
        Text("👃  Inhale through your nose", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Text("👄  Exhale through pursed lips", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(32.dp))

        // Timer
        Text(
            text = "3 min",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Start button
        Button(
            onClick = onStartExerciseClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFE77B7) // din pink farve
            )
        ) {
            Text("Start exercise")
        }

    }
}
