package com.example.hongjun.plantodo

import android.app.Application
import android.arch.persistence.room.Room

class Application : Application() {

    companion object {
        private lateinit var INSTANCE : Application
        fun getInstance() = INSTANCE

        lateinit var appDatabase : AppDatabase
    }

    //자원 소비가 크기 때문에 싱글톤으로 구현
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        appDatabase = Room.databaseBuilder(this, AppDatabase::class.java, "todo.-db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build()
    }


}