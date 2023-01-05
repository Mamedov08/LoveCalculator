package com.example.lovecalculator.remote

import retrofit2.Call
import retrofit2.http.*

interface LoveApi {

    @GET("getPercentage")
    fun getResultLove(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key")key:String ="2d5cc38983msh33c2ea6e6b7834dp110e9cjsnda2457f2eccd",
        @Header("X-RapidAPI-Host")host:String = "love-calculator.p.rapidapi.com",


    ): Call<LoveModel>

}

