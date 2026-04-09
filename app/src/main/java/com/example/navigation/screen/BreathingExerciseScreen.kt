package com.example.navigation.screen

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import com.example.navigation.components.HeartShape
import kotlinx.coroutines.delay

@Composable
fun BreathingExerciseScreen(
    onBackClick: () -> Unit,
    onStartExerciseClick: () -> Unit
) {
    val durations = listOf(10, 180, 360, 540)
    var selectedDuration by remember { mutableIntStateOf(180) } // 180 = 3 min
    var timeLeft by remember { mutableIntStateOf(selectedDuration) }
    var isRunning by remember { mutableStateOf(false) }
    var showFinishScreen by remember { mutableStateOf(false) }

    LaunchedEffect(isRunning, timeLeft) {
        if (isRunning && timeLeft > 0) {
            delay(1000)
            timeLeft--
        }
        if (timeLeft == 0 && isRunning) {
            isRunning = false
            showFinishScreen = true
        }

    }
    @Composable
    fun BackButton(onBackClick: () -> Unit) {
        IconButton(onClick = onBackClick) {
            Icon(
                painter = painterResource(id = R.drawable.arrowicon),
                contentDescription = "Back",
                tint = Color.Black
            )
        }
    }
    if (showFinishScreen) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xAA000000)), // Semi transparent overlay
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .size(360.dp) // Fast størrelse, så hjertet er stabilt
                    .clip(HeartShape) // Klip indholdet, efter hjerte formen
                    .background(Color.White, shape = HeartShape)
                    .padding(
                        top = 90.dp,
                        bottom = 40.dp,
                        start = 24.dp,
                        end = 24.dp
                    )
            ) {
                Text(
                    text = "Well done!",
                    fontSize = 28.sp,
                    color = Color(0xFFFE77B7)
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = if (selectedDuration < 60)
                        "You have completed $selectedDuration seconds"
                    else
                        "You have completed ${selectedDuration / 60} minutes",
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        showFinishScreen = false
                        timeLeft = selectedDuration
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFE77B7)
                    )
                ) {
                    Text("Close", fontSize = 16.sp)
                }
            }
        }
        return
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
        Text("👃  Inhale through your nose", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text("👄  Exhale through pursed lips", fontSize = 28.sp)

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            durations.forEach { duration ->
                Box(
                    modifier = Modifier
                        .background(
                            if (selectedDuration == duration) Color(0xFFFE77B7) else Color.LightGray,
                            shape = CircleShape
                        )
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            selectedDuration = duration
                            timeLeft = duration
                        }
                )
                {
                    Text(
                        text = if (duration < 60) "${duration} sec" else "${duration / 60} min",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
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
            Text(if (isRunning) "Stop" else "Start", fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        //Nulstil button
        Button(
            onClick = {
                isRunning = false
                timeLeft = selectedDuration
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray
            )
        ) {
            Text("Nulstil", fontSize = 18.sp)
        }
    }
}
