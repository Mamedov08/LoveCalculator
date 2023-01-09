package com.example.lovecalculator.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.remote.LoveModel


@Dao
interface LoveDao {



    @Insert
    fun insertLove(model: LoveModel)

    @Query("SELECT * FROM loveModel ORDER BY firstName")
    fun getAll(): LiveData <List<LoveModel>>


}

