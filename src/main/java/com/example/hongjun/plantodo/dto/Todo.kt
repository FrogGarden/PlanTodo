package com.example.hongjun.plantodo.dto

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

//Model 역할을 함
@Entity(tableName = "todo")
data class Todo(
        var title : String?,
        var content : String?,
        var date : String?,
        var done : Boolean = false,

        @PrimaryKey(autoGenerate = true)
        var id : Long = 0
)
