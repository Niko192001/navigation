package com.example.heart2heart.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.heart2heart.R

@Composable
fun HomeScreen(navController: NavHostController) {
    val pink = Color(0xFFF47DBB)
    val gray = Color(0xFF8E8E8E)
    val bg = Color(0xFFF5F5F5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "Home",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = pink
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(R.drawable.keychainhearticon),
            contentDescription = "Heart device",
            modifier = Modifier.size(190.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.bluetoothicon),
                    contentDescription = "Bluetooth",
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("connected", color = gray, fontSize = 14.sp)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.batteryicon),
                    contentDescription = "Battery",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("95%", color = gray, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(55.dp))

        Text(
            text = "If your device isn’t responding, you can start\nor stop vibration here",
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = pink),
            modifier = Modifier
                .width(220.dp)
                .height(52.dp)
        ) {
            Text("Activate vibration", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = pink),
            modifier = Modifier
                .width(220.dp)
                .height(52.dp)
        ) {
            Text("Stop vibration", color = Color.White)
        }

        Spacer(modifier = Modifier.weight(1f))
        HorizontalDivider(color = Color.LightGray)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            NavItem(R.drawable.connecthearticon, "Connect", pink) { }
            NavItem(R.drawable.homeicon, "Home", pink) { }
            NavItem(R.drawable.breathe, "Breathe", pink) {
                navController.navigate("breathe") {
                    launchSingleTop = true
                }
            }
            NavItem(R.drawable.contactsicon, "Contacts", pink) { }
        }
    }
}

@Composable
fun NavItem(
    icon: Int,
    label: String,
    color: Color,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = label,
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = label, color = color, fontSize = 12.sp)
    }
}