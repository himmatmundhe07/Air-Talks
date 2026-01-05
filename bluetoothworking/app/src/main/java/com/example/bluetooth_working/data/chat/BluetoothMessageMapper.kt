package com.example.bluetooth_working.data.chat

import com.example.bluetooth_working.domain.chat.BluetoothMessage

fun String.toBluetoothMessage(isFromLocalUser: Boolean): BluetoothMessage {
    val parts = split('#')
    val senderName = parts.getOrNull(0) ?: "Unknown"
    val message = parts.getOrNull(1) ?: ""
    val timestamp = parts.getOrNull(2)?.toLongOrNull() ?: System.currentTimeMillis()

    return BluetoothMessage(
        message = message,
        senderName = senderName,
        isFromLocalUser = isFromLocalUser,
        timestamp = timestamp
    )
}

fun BluetoothMessage.toByteArray(): ByteArray {
    return "$senderName#$message#$timestamp".encodeToByteArray()
}