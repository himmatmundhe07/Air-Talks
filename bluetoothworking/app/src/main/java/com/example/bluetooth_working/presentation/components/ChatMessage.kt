package com.example.bluetooth_working.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bluetooth_working.domain.chat.BluetoothMessage
import com.example.bluetooth_working.ui.theme.BluetoothworkingTheme
import com.example.bluetooth_working.ui.theme.NeonCyan
import com.example.bluetooth_working.ui.theme.NeonPurple
import com.example.bluetooth_working.ui.theme.TextGray
import com.example.bluetooth_working.ui.theme.TextWhite
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ChatMessage(
    message: BluetoothMessage,
    modifier: Modifier = Modifier
) {
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val time = timeFormat.format(Date(message.timestamp))

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(
                Brush.verticalGradient(
                    colors = if (message.isFromLocalUser) {
                        listOf(NeonPurple.copy(alpha = 0.4f), NeonCyan.copy(alpha = 0.4f))
                    } else {
                        listOf(Color.DarkGray, Color.Gray)
                    }
                )
            )
            .drawBehind {
                drawRoundRect(
                    brush = Brush.linearGradient(
                        colors = if (message.isFromLocalUser) {
                            listOf(NeonPurple, NeonCyan)
                        } else {
                            listOf(Color.Gray, Color.DarkGray)
                        }
                    ),
                    style = Stroke(width = 2.dp.toPx())
                )
            }
            .padding(12.dp)
    ) {
        Column {
            Text(
                text = message.senderName,
                fontSize = 12.sp,
                color = if (message.isFromLocalUser) NeonCyan else TextWhite
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message.message,
                color = TextWhite,
                modifier = Modifier.widthIn(max = 250.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = time,
                fontSize = 10.sp,
                color = TextGray,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Preview
@Composable
fun ChatMessagePreview() {
    BluetoothworkingTheme {
        ChatMessage(
            message = BluetoothMessage(
                message = "Hello World!",
                senderName = "Pixel 6",
                isFromLocalUser = false,
                timestamp = System.currentTimeMillis()
            )
        )
    }
}
