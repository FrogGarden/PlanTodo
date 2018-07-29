package com.example.hongjun.plantodo

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.util.Log
import com.example.hongjun.plantodo.module.ApplicationModule
import org.example.hongjun.plantodo.ApplicationComponent
import org.example.hongjun.plantodo.DaggerApplicationComponent


class Application : Application() {

    val singleton : ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

    }

    companion object {
        private lateinit var INSTANCE : Application
        fun getInstance() = INSTANCE

        lateinit var appDatabase : AppDatabase



    }


    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        appDatabase = Room.databaseBuilder(this, AppDatabase::class.java, "todo.-db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build()

        singleton.inject(this)

        fun getApplicationComponent(context: Context): ApplicationComponent{
            return (context.applicationContext as com.example.hongjun.plantodo.Application).singleton
        }


    }




}


