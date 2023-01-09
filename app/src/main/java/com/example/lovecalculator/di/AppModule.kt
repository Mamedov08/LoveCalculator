package com.example.lovecalculator.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.lovecalculator.remote.LoveApi
import com.example.lovecalculator.room.AppDataBase
import com.example.lovecalculator.room.LoveDao
import com.example.lovecalculator.ui.HomeFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

class AppModule {
    @Provides
    fun  provideApi(): LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi :: class.java)
    }

    @Provides
    fun providePreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("settings",Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDataBase::class.java, "note_db").allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun provideNoteDao(appDatabase: AppDataBase) = appDatabase.getDao()

//    @Provides
//    fun provideNoteRepository(loveDao: LoveDao): HomeFragment {
//        return HomeFragment()
//    }

}