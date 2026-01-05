package com.example.bluetooth_working.domain.chat

data class BluetoothMessage(
    val message: String,
    val senderName: String,
    val isFromLocalUser: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)
