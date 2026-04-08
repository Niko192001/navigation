package com.example.navigation.screen

import android.text.Layout
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay


@Composable
fun BreathingExerciseScreen(
    onBackClick: () -> Unit,
    onStartExerciseClick: () -> Unit
) {
    val durations = listOf(180, 360, 540, 720)
    var selectedDuration by remember { mutableStateOf(180) } // 180 = 3 min
    var timeLeft by remember { mutableStateOf(selectedDuration) }
    var isRunning by remember { mutableStateOf(false) }
    LaunchedEffect(isRunning, timeLeft) {
        if (isRunning && timeLeft > 0) {
            delay(1000)
            timeLeft--
        }
    }
    @Composable
    fun BackButton(onBackClick: () -> Unit) {
        IconButton(onClick = onBackClick) {
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onBackClick,
                modifier = Modifier
                    .height(36.dp)
                    .width(80.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFE77B7)
                )
            ) {
                Text("Back", fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Pursed Lip Breathing",
            fontSize = 24.sp,
            color = Color(0xFFFE77B7),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Spacer(modifier = Modifier.height(24.dp))

        // Illustrations (placeholder text)
        Text("👃  Inhale through your nose", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text("👄  Exhale through pursed lips", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            durations.forEach { duration ->
                Button(
                    onClick = {
                        selectedDuration = duration
                        timeLeft = duration
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedDuration == duration)
                            Color(0xFFFE77B7)
                        else
                            Color.LightGray
                    )
                ) {
                    Text("${duration / 60} min")
                }
            }
        }

        // Timer
        Text(
            text = "${timeLeft / 60}:${(timeLeft % 60).toString().padStart(2, '0')}",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .padding(8.dp)
                .background(Color(0xFFFE77B7), shape = CircleShape)
                .padding(horizontal = 24.dp, vertical = 12.dp)


        )

        Spacer(modifier = Modifier.weight(1f))

        // Start button
        Button(
            onClick = {
                isRunning = !isRunning
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFE77B7) // din pink farve
            )
        ) {
            Text(if (isRunning) "Stop exercise" else "Start exercise", fontSize = 20.sp)
        }

    }
}
