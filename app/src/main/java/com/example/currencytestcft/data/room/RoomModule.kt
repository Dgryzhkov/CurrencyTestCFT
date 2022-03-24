package com.example.currencytestcft.data.room

import android.content.Context
import androidx.room.Room

object RoomModule {

    lateinit var appdataBase : AppDataBase

    fun init(context: Context) {
        appdataBase = Room.databaseBuilder(context, AppDataBase::class.java, "database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}