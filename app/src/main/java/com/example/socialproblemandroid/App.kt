package com.example.socialproblemandroid

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        stopDarkMode()
    }

    private fun stopDarkMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}