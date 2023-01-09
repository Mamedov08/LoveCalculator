package com.example.lovecalculator.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(tableName = "loveModel")
data class LoveModel(

    @SerializedName ("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var persentage: String,
    var result: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    )