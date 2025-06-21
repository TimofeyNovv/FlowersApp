package com.example.flowerly.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flowerly.R
import com.example.flowerly.ui.theme.fontFamilyMerriweatherItatic
import com.example.flowerly.ui.theme.fontFamilyPacificoregular

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.backgroundflowerly),
            contentDescription = "BG",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamilyMerriweatherItatic,

                )

            Text(
                text = "Flowerfly!",
                fontSize = 50.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = fontFamilyPacificoregular,
                color = Color(0xFF198155),
                modifier = Modifier.padding(top = 10.dp)
            )

            Button(
                onClick = {},
                modifier = Modifier.padding(top = 130.dp).width(290.dp).height(45.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF23C16B)
                )) {
                Text(
                    text = "Continue",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = fontFamilyMerriweatherItatic
                )
            }
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPrev() {
    WelcomeScreen()
}