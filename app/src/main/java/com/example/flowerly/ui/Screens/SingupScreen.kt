package com.example.flowerly.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flowerly.R
import com.example.flowerly.ui.Screens.Slots.SingUpLogsSlot
import com.example.flowerly.ui.theme.fontFamilyMerriweatherItatic

@Composable
fun SingUpScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onSignUpComplete: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.backgroundflowerly),
            contentDescription = "BG",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .padding(start = 14.dp, end = 14.dp, top = 100.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .background(
                    Color.White
                )
                .fillMaxSize()
        ) {
            Column {
                Text(
                    text = "Sing Up",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fontFamilyMerriweatherItatic,
                    color = Color(0xFF198155),
                    modifier = Modifier.padding(start = 20.dp, top = 40.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp, end = 15.dp, top = 20.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFDAEFDE),
                            unfocusedBorderColor = Color(0xFFDAEFDE)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFDAEFDE),
                            unfocusedBorderColor = Color(0xFFDAEFDE)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp)
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFDAEFDE),
                            unfocusedBorderColor = Color(0xFFDAEFDE)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp)
                    )


                    Button(
                        onClick = onSignUpComplete, colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF23C16B)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Sing Up",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = fontFamilyMerriweatherItatic,
                            color = Color.White
                        )
                    }

                    Text(
                        text = "Continue with",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        fontFamily = fontFamilyMerriweatherItatic,
                        color = Color(0xFF198155),
                        modifier = Modifier.padding(top = 14.dp)
                    )

                    Row(
                        modifier = Modifier.padding(top = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.clickable {

                        }) {
                            SingUpLogsSlot {
                                Image(
                                    painter = painterResource(id = R.drawable.googlelog),
                                    contentDescription = "GoogleLog",
                                    modifier = Modifier,
                                    alignment = Alignment.Center
                                )
                            }
                        }

                        Spacer(modifier = Modifier.size(20.dp))
                        Box(modifier = Modifier.clickable {

                        }) {
                            SingUpLogsSlot {
                                Image(
                                    painter = painterResource(id = R.drawable.applelog),
                                    contentDescription = "AppleLog",
                                    modifier = Modifier,
                                    alignment = Alignment.Center
                                )
                            }
                        }

                        Spacer(modifier = Modifier.size(20.dp))
                        Box(modifier = Modifier.clickable {

                        }) {
                            SingUpLogsSlot {
                                Image(
                                    painter = painterResource(id = R.drawable.facebooklog),
                                    contentDescription = "FacebookLog",
                                    modifier = Modifier,
                                    alignment = Alignment.Center
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}
