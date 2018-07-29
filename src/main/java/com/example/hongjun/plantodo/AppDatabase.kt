package com.example.hongjun.plantodo

import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.Database
import android.arch.persistence.room.DatabaseConfiguration
import android.arch.persistence.room.InvalidationTracker
import android.arch.persistence.room.RoomDatabase
import com.example.hongjun.plantodo.dao.TodoDao
import com.example.hongjun.plantodo.dto.Todo
import kotlin.reflect.KClass

//database의 holder
@Database(version = 2, entities = arrayOf(Todo::class))
abstract class AppDatabase : RoomDatabase(){

    abstract fun todoDao() : TodoDao

}