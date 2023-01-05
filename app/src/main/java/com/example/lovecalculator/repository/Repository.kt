package com.example.lovecalculator.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.RetrofitService
import com.example.lovecalculator.remote.LoveApi
import com.example.lovecalculator.remote.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject  constructor( private val api: LoveApi){

    fun getLiveLove(firstName: String, secondName: String) : MutableLiveData<LoveModel> {

        var liveData = MutableLiveData<LoveModel>()

        api.getResultLove(firstName,secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    liveData.postValue(response.body())
                    Log.e("ololo", "hnbv:")

                }
        }
            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}",)
            }


        }

        )

        return liveData


    }


}