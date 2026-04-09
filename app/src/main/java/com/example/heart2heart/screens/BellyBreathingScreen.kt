package com.example.heart2heart.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heart2heart.BackButton
import com.example.heart2heart.R
import com.example.heart2heart.components.HeartShape
import kotlinx.coroutines.delay


@Composable
fun BellyBreathingScreen(
    onBackClick: () -> Unit
) {
    val durations = listOf(10, 180, 360, 540)
    var selectedDuration by remember { mutableIntStateOf(180) }
    var timeLeft by remember { mutableIntStateOf(180) }
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

    // Til selve skærmen, når man har fuldført en øvelse.

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
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            BackButton(onBackClick = onBackClick)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Dette er vores titel sektion med ikonerne.

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.breathein),
                contentDescription = "Left icon",
                modifier = Modifier.height(36.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.padding(horizontal = 8.dp))

            Text(
                text = "Belly Breathing",
                fontSize = 20.sp,
                color = Color(0xFFFF69B4)
            )

            Spacer(modifier = Modifier.padding(horizontal = 8.dp))

            Image(
                painter = painterResource(id = R.drawable.breatheout),
                contentDescription = "Right icon",
                modifier = Modifier.height(36.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.bellybreathing),
            contentDescription = "Belly Breathing Instructions",
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Det her er timer sektionen, til valg af længde for øvelsen.

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            durations.forEach { duration ->
                Text(
                    text = if (duration < 60) "$duration sec" else "${duration / 60} min",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(
                            if (selectedDuration == duration) Color(0xFFFE77B7)
                            else Color.LightGray
                        )
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            selectedDuration = duration
                            timeLeft = duration
                            isRunning = false
                        }
                        .padding(horizontal = 18.dp, vertical = 10.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "${timeLeft / 60}:${(timeLeft % 60).toString().padStart(2, '0')}",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .clip(CircleShape)
                .background(Color(0xFFFE77B7))
                .padding(horizontal = 24.dp, vertical = 12.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                isRunning = !isRunning
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF69B4)
            )
        ) {
            Text(
                text = if (isRunning) "Pause Exercise" else "Start Exercise",
                fontSize = 18.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

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
            Text(
                text = "Reset",
                fontSize = 16.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}