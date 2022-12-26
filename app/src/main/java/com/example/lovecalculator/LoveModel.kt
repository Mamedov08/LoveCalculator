package com.example.lovecalculator

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoveModel(
    @SerializedName ("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var persentage: String,
    var result: String
): Serializable
