package com.example.lovecalculator

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class Prefs @Inject constructor(private val sharedPreferences : SharedPreferences) {

    fun saveState() {
        sharedPreferences.edit().putBoolean("isShow", true).apply()
    }


    fun isShown(): Boolean {
        return sharedPreferences.getBoolean("isShow", false)
    }
}