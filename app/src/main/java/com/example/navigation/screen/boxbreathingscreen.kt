package com.example.navigation.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.ui.layout.ContentScale

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigation.R

@Composable
fun boxbreathingscreen(
    onBackClick: () -> Unit,
    onStartExerciseClick: () -> Unit
) {

    Column(
    modifier = Modifier.fillMaxWidth()
    ,horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row() {


            Text(
                "Box breathing",
                fontSize = 40.sp,
                color = Color(0x88FE77B7),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 60.dp)


            )

            Image(
                painter = painterResource(id = R.drawable.`in`),
                contentDescription = "in",
                modifier = Modifier
                    .width(3.dp)

            )
        }
        Image(
            painter = painterResource(id = R.drawable.boxbreathing),
            contentDescription = "Belly Breathing Instructions",
            modifier = Modifier
                .fillMaxWidth()

                .height(300.dp)


        )
        Text(
            text = "1. Inhale – Breathe in slowly through your nose, filling your lungs completely.",
            modifier = Modifier.width(350.dp),
            style = TextStyle(fontSize = 10.sp),
            fontWeight = FontWeight.Bold,





            )
        Text(
            text = "2.Hold – Pause and hold the breath for the same duration, keeping your body relaxed.",
            modifier = Modifier.width(350.dp),
            style = TextStyle(fontSize = 10.sp),
            fontWeight = FontWeight.Bold,




            )
        Text(
            text = "3. Exhale – Slowly release the breath through your mouth, emptying your lungs fully.",
            modifier = Modifier.width(350.dp),
            style = TextStyle(fontSize = 10.sp),
            fontWeight = FontWeight.Bold,






            )
        Text(
            text = "4.Hold – Pause again with empty lungs for the same duration before repeating.",
            modifier = Modifier.width(350.dp),
            style = TextStyle(fontSize = 10.sp),
            fontWeight = FontWeight.Bold,





            )


        Button(
            onClick=  { println("hej") },
            modifier = Modifier.padding(top = 325.dp) .width(200.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 3.dp,
                pressedElevation = 3.dp
            ),
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = Color(0x88FE77B7),
                disabledContainerColor = Color(0x88FE77B7),
                disabledContentColor = Color(0x88FE77B7),
            )

        ) {
            Text(
                text = "Start exercise",
                style = TextStyle(fontSize = 20.sp)
            )


        }




    }
}















