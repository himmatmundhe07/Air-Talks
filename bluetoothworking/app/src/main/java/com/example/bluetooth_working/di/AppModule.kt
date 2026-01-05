package com.example.bluetooth_working.di

import android.content.Context
import com.example.bluetooth_working.data.chat.AndroidBluetoothController
import com.example.bluetooth_working.data.chat.UsernameManager
import com.example.bluetooth_working.domain.chat.BluetoothController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBluetoothController(@ApplicationContext context: Context): BluetoothController {
        return AndroidBluetoothController(context)
    }

    @Provides
    @Singleton
    fun provideUsernameManager(@ApplicationContext context: Context): UsernameManager {
        return UsernameManager(context)
    }
}