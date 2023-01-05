package com.example.lovecalculator

import android.content.Context
import android.widget.Toast
import com.example.lovecalculator.ui.HomeFragment


    fun Context.showToast(context: Context,msg:String){
        Toast.makeText(context, msg, Toast. LENGTH_LONG).show()
    }
