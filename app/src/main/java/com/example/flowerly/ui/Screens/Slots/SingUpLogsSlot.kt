package com.example.flowerly.ui.Screens.Slots

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SingUpLogsSlot(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = Modifier
        .height(55.dp)
        .width(80.dp)
        .clip(shape = RoundedCornerShape(12.dp))
        .background(color = Color(0xFFF2F4F5)),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}